package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.viaedge.kheloindiafootball.Fragments.ExploreFragment;
import com.viaedge.kheloindiafootball.Fragments.FixturesFragment;
import com.viaedge.kheloindiafootball.Fragments.MatchViewFragment;
import com.viaedge.kheloindiafootball.Fragments.ResultTableFragment;
import com.viaedge.kheloindiafootball.Fragments.TeamFragment;
import com.viaedge.kheloindiafootball.R;

public class DefaultActivity extends AppCompatActivity {
    String fragment= null;
    ExploreFragment exploreFragment;
    FixturesFragment fixturesFragment;
    TeamFragment teamFragment;
    MatchViewFragment matchViewFragment;
    ResultTableFragment resultTableFragment;
    TextView toolbartext;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    ImageView goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        exploreFragment = new ExploreFragment();
        fixturesFragment = new FixturesFragment();
        teamFragment = new TeamFragment();
        resultTableFragment = new ResultTableFragment();
        matchViewFragment = new MatchViewFragment();
        toolbartext = findViewById(R.id.toolbartext);
        goback = findViewById(R.id.goback);
        goback.setOnClickListener(v -> {
            onBackPressed();
        });
        Bundle b = getIntent().getExtras();
        fragmentManager = getSupportFragmentManager();
        if(b!=null){
            fragment = b.getString("fragment");
        }
        if(fragment!=null){
            if(fragment.equals("explore")) {
                toolbartext.setText("EXPLORE");
                ft = fragmentManager.beginTransaction()
                        .add(R.id.defaultframe,exploreFragment);
                ft.commit();
            }
            if(fragment.equals("fixtures")){
                toolbartext.setText("FIXTURES");
                ft = fragmentManager.beginTransaction()
                        .add(R.id.defaultframe,fixturesFragment);
                ft.commit();
            }
            if(fragment.equals("team")){
                toolbartext.setText("TEAM");
                ft = fragmentManager.beginTransaction()
                        .add(R.id.defaultframe,teamFragment);
                ft.commit();
            }
            if(fragment.equals("result")){
                toolbartext.setText("RESULT TABLE");
                ft = fragmentManager.beginTransaction()
                        .add(R.id.defaultframe,resultTableFragment);
                ft.commit();
            }
            if(fragment.equals("match")){
                toolbartext.setText("MATCH");
                ft = fragmentManager.beginTransaction()
                        .add(R.id.defaultframe,matchViewFragment);
                ft.commit();
            }
        }


    }
}
