package com.viaedge.kheloindiafootball.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;


public class TeamFragment extends Fragment {
    RelativeLayout lookingFor,lineUp,teamStats;
    FrameLayout teamFrame;
    LineUpFragment lineUpFragment;
    LookingForFragment lookingForFragment;
    TeamStats teamStatsFragment;
    FragmentTransaction ft;
    int selected;
    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(view);
        teamFrame = view.findViewById(R.id.teamFrame);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        lineUpFragment = new LineUpFragment();
        lookingForFragment = new LookingForFragment();
        teamStatsFragment = new TeamStats();
        selected = 2;
        ft = fragmentManager.beginTransaction()
                .add(R.id.teamFrame,lineUpFragment);
        ft.commit();
        lookingFor = view.findViewById(R.id.lookingFor);
        lineUp = view.findViewById(R.id.lineUp);
        teamStats = view.findViewById(R.id.teamStats);
        lookingFor.setOnClickListener(v -> {
            if(selected!=1){
                lookingFor.setBackgroundResource(R.color.white);
                lineUp.setBackgroundResource(R.color.gray);
                teamStats.setBackgroundResource(R.color.gray);
                ft = fragmentManager.beginTransaction()
                        .replace(R.id.teamFrame,lookingForFragment);
                ft.commit();
                selected = 1;
            }
        });
        lineUp.setOnClickListener(v -> {
            if(selected!=2){
                lookingFor.setBackgroundResource(R.color.gray);
                lineUp.setBackgroundResource(R.color.white);
                teamStats.setBackgroundResource(R.color.gray);
                ft = fragmentManager.beginTransaction()
                        .replace(R.id.teamFrame,lineUpFragment);
                ft.commit();
                selected = 2;
            }
        });
        teamStats.setOnClickListener(v -> {
            if(selected!=3){
                lookingFor.setBackgroundResource(R.color.gray);
                lineUp.setBackgroundResource(R.color.gray);
                teamStats.setBackgroundResource(R.color.white);
                ft = fragmentManager.beginTransaction()
                        .replace(R.id.teamFrame,teamStatsFragment);
                ft.commit();
                selected = 3;
            }
        });

        return view;
    }
}


