package com.viaedge.kheloindiafootball.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;
import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;


public class ExploreFragment extends Fragment {

    MaterialRadioButton player,team;
    TextView lookingfor;
    LinearLayout playersearch,teamsearch;
    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(view);
        player = view.findViewById(R.id.playerradio);
        team = view.findViewById(R.id.teamradio);
        lookingfor = view.findViewById(R.id.lookingfor);
        playersearch = view.findViewById(R.id.playersearch);
        teamsearch = view.findViewById(R.id.teamsearch);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        player.setChecked(true);
        team.setOnClickListener( v -> {
                lookingfor.setText("Looking for a Team ? ");
                player.setChecked(false);
                playersearch.setVisibility(View.GONE);
                teamsearch.setVisibility(View.VISIBLE);

        });
        player.setOnClickListener(v -> {
                lookingfor.setText("Looking for a Player ? ");
                team.setChecked(false);
                teamsearch.setVisibility(View.GONE);
                playersearch.setVisibility(View.VISIBLE);

        });
    }
}
