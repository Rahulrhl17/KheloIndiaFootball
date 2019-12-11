package com.viaedge.kheloindiafootball.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;


public class ResultTableFragment extends Fragment {


    public ResultTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_table, container, false);
        ButterKnife.bind(view);
        return view;
    }

}
