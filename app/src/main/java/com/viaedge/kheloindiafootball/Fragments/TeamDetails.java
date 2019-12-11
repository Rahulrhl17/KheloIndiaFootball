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

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamDetails extends Fragment {
    MaterialButton next,back;
    StateProgressBar stateProgressBar;

    public TeamDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_details, container, false);
        ButterKnife.bind(view);
        next = view.findViewById(R.id.next);
        back = view.findViewById(R.id.back);
        stateProgressBar = ((TeamRegistration)getActivity()).getStateProgressBar();
        back.setOnClickListener(v -> {
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
            FragmentManager fm = getActivity().getSupportFragmentManager();
            TeamPersonalDetails teamPersonalDetails = new TeamPersonalDetails();
            FragmentTransaction ft = fm.beginTransaction()
                    .replace(R.id.registerframe,teamPersonalDetails);
            ft.commit();
        });
        return view;
    }

}
