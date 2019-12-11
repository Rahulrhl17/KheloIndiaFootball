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
import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerPersonalDetails extends Fragment {
    private MaterialButton next;
    private StateProgressBar stateProgressBar;

    public PlayerPersonalDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_personal_details,container,false);
        ButterKnife.bind(view);
        next = view.findViewById(R.id.next);

        next.setOnClickListener(v -> {
            stateProgressBar = ((PlayerRegistration)getActivity()).getStateProgressBar();
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
            FragmentManager fm = getActivity().getSupportFragmentManager();
            PlayerProfessionalDetails playerProfessionalDetails = new PlayerProfessionalDetails();
            FragmentTransaction ft = fm.beginTransaction()
                    .replace(R.id.registerframe,playerProfessionalDetails);
            ft.commit();
        });
        return view;
    }

}
