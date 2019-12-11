package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.viaedge.kheloindiafootball.R;

public class LoginActivity extends AppCompatActivity {
    MaterialButton register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.register);
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        });
    }
}
