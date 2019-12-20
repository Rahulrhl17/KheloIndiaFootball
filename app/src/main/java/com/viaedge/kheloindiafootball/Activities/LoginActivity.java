package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.viaedge.kheloindiafootball.R;
import com.viaedge.kheloindiafootball.Services.LoginService;

public class LoginActivity extends AppCompatActivity {
    MaterialButton register,login;
    TextInputLayout usernameLayout,passwordLayout;
    TextInputEditText usernameText,passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.register);
        usernameLayout = findViewById(R.id.usernameLayout);
        usernameText = findViewById(R.id.usernameText);
        passwordLayout = findViewById(R.id.passwordLayout);
        passwordText = findViewById(R.id.passwordText);
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            int validate = validation();
            if(validate == 0){
                login();
            }
            else if(validate ==1){
                usernameLayout.setErrorEnabled(true);
                usernameLayout.setError("Enter Username");
            }
            else if(validate ==2){
                passwordLayout.setError("Enter Password");
                passwordLayout.setErrorEnabled(true);
            }
        });
    }

    private int validation(){
        int validate = 0;
        if (usernameText.getText().toString().isEmpty()){
            validate = 1;
        }
        else if(passwordText.getText().toString().isEmpty()){
            validate = 2;
        }
        return validate;
    }
    private void login(){
        LoginService loginService = new LoginService(this);
        loginService.login();
    }
}
