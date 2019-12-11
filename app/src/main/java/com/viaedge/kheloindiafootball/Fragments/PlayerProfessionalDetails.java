package com.viaedge.kheloindiafootball.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.viaedge.kheloindiafootball.Activities.PlayerRegistration;
import com.viaedge.kheloindiafootball.Activities.RegisterActivity;
import com.viaedge.kheloindiafootball.Activities.TeamRegistration;
import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;

public class PlayerProfessionalDetails extends Fragment {
    private MaterialButton next,back;
    PlayerPersonalDetails playerPersonalDetails;
    StateProgressBar stateProgressBar;
    public PlayerProfessionalDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_professional_details, container, false);
        playerPersonalDetails = new PlayerPersonalDetails();
        stateProgressBar = ((PlayerRegistration)getActivity()).getStateProgressBar();

        next =view.findViewById(R.id.next);
        back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction()
                    .replace(R.id.registerframe,playerPersonalDetails);
            ft.commit();
        });
        ButterKnife.bind(view);
        return view;
    }

}
