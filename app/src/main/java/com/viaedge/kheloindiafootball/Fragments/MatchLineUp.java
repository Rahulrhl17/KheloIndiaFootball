package com.viaedge.kheloindiafootball.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;


public class MatchLineUp extends Fragment {

    TextView team1,team2;
    int selected = 1;
    public MatchLineUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_line_up, container, false);
        ButterKnife.bind(view);
        team1 = view.findViewById(R.id.team1Name);
        team2 = view.findViewById(R.id.team2Name);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        team1.setOnClickListener(v -> {
            if (selected != 1){
                team1.setBackgroundResource(R.color.white);
                team2.setBackgroundResource(R.color.gray);
                selected = 1;
            }
        });
        team2.setOnClickListener(v -> {
            if(selected!=2){
                team1.setBackgroundResource(R.color.gray);
                team2.setBackgroundResource(R.color.white);
                selected = 2;
            }
        });
    }
}
