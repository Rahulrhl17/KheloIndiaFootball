package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.viaedge.kheloindiafootball.Fragments.PlayerPersonalDetails;
import com.viaedge.kheloindiafootball.Fragments.TeamPersonalDetails;
import com.viaedge.kheloindiafootball.R;

public class TeamRegistration extends AppCompatActivity {
    TeamPersonalDetails teamPersonalDetails;
    StateProgressBar stateProgressBar;

    public StateProgressBar getStateProgressBar() {
        return stateProgressBar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_registration);
        teamPersonalDetails = new TeamPersonalDetails();
        stateProgressBar = findViewById(R.id.stateprogressbar);
        String[]  titles = {"\nPersonal\nDetails","\nTeam\nDetails","\nPayment\nDetails"};
        stateProgressBar.setStateDescriptionData(titles);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .add(R.id.registerframe,teamPersonalDetails);
        ft.commit();
    }
}
