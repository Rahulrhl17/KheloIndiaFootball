package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.viaedge.kheloindiafootball.R;

public class ProfileActivity extends AppCompatActivity {
    ImageView goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        goback = findViewById(R.id.goback);
        goback.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}
