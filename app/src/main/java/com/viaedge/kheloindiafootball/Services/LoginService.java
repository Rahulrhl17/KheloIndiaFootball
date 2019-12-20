package com.viaedge.kheloindiafootball.Services;

import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.viaedge.kheloindiafootball.Activities.HomeActivity;
import com.viaedge.kheloindiafootball.Activities.LoginActivity;
import com.viaedge.kheloindiafootball.ApiClient.ApiInterface;
import com.viaedge.kheloindiafootball.ApiClient.ServiceGenerator;

import com.viaedge.kheloindiafootball.Model.UserModel;
import com.viaedge.kheloindiafootball.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    LoginActivity loginActivity;
    private List<UserModel> userModels;

    public LoginService(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    public void login(){
        TextInputEditText usernameText,passwordText;
        usernameText = loginActivity.findViewById(R.id.usernameText);
        passwordText = loginActivity.findViewById(R.id.passwordText);
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String credentials = "(username,eq,"+username+")~and(password,eq,"+password+")";
        ApiInterface service = ServiceGenerator.login(ApiInterface.class,credentials);
        Call<List<UserModel>> call = service.login(credentials);
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if(response.isSuccessful() &&response.body()!=null){
                    if(response.body().size()==0){
                        Toast.makeText(loginActivity.getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                    }
                    else if(!(response.body().size() ==0)){
                        userModels =response.body();
                        int userid = response.body().get(0).getUserid();
                        int usertype = response.body().get(0).getUsertype();
                        String firstname = response.body().get(0).getFirstname().toUpperCase();
                        String lastname = response.body().get(0).getLastname().toUpperCase();
                        Intent intent = new Intent(loginActivity.getApplicationContext(), HomeActivity.class);
                        intent.putExtra("userid",userid);
                        intent.putExtra("usertype",usertype);
                        intent.putExtra("firstname",firstname);
                        intent.putExtra("lastname",lastname);
                        loginActivity.startActivity(intent);
                        loginActivity.finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });
    }
}
