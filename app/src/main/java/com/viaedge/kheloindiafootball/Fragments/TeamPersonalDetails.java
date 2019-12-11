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
import com.viaedge.kheloindiafootball.Activities.TeamRegistration;
import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;

public class TeamPersonalDetails extends Fragment {

    MaterialButton next;
    StateProgressBar stateProgressBar;

    public TeamPersonalDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_personal_details, container, false);
        ButterKnife.bind(view);
        next = view.findViewById(R.id.next);
        stateProgressBar = ((TeamRegistration)getActivity()).getStateProgressBar();
        next.setOnClickListener(v -> {
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
            FragmentManager fm = getActivity().getSupportFragmentManager();
            TeamDetails teamDetails = new TeamDetails();
            FragmentTransaction ft = fm.beginTransaction()
                    .replace(R.id.registerframe,teamDetails);
            ft.commit();
        });
        return view;
    }

}
