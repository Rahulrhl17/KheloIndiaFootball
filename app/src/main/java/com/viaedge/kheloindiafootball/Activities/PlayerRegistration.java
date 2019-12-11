package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.viaedge.kheloindiafootball.Fragments.PlayerPersonalDetails;
import com.viaedge.kheloindiafootball.R;

public class PlayerRegistration extends AppCompatActivity {
    FrameLayout registerFrame;
    PlayerPersonalDetails playerPersonalDetails;
    StateProgressBar stateProgressBar;
    ImageView goback;
    public StateProgressBar getStateProgressBar() {
        return stateProgressBar;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_registration);
        playerPersonalDetails = new PlayerPersonalDetails();
        stateProgressBar = findViewById(R.id.stateprogressbar);
        goback = findViewById(R.id.goback);
        goback.setOnClickListener(v -> {
            onBackPressed();
        });
        String[]  titles = {"\nPersonal\nDetails","\nProfessional\nDetails","\nPayment\nDetails"};
        stateProgressBar.setStateDescriptionData(titles);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .add(R.id.registerframe,playerPersonalDetails);
        ft.commit();
    }
}
