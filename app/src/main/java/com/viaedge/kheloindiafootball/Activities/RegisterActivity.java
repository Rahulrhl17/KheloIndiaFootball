package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.viaedge.kheloindiafootball.R;

public class RegisterActivity extends AppCompatActivity {
    RelativeLayout playerLayout,teamLayout;
    ImageView goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        playerLayout = findViewById(R.id.playerLayout);
        teamLayout = findViewById(R.id.teamLayout);
        goback = findViewById(R.id.goback);
        goback.setOnClickListener(v -> {
            onBackPressed();
        });
        teamLayout.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this,TeamRegistration.class);
            startActivity(intent);
        });
        playerLayout.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this,PlayerRegistration.class);
            startActivity(intent);
        });
    }
}
