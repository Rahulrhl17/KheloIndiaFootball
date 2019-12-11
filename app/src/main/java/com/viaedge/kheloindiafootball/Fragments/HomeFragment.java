package com.viaedge.kheloindiafootball.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viaedge.kheloindiafootball.Activities.DefaultActivity;
import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private CardView resultsCard;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(view);
        resultsCard = view.findViewById(R.id.resultsCard);

        resultsCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getApplicationContext(), DefaultActivity.class);
            intent.putExtra("fragment","result");
            getActivity().startActivity(intent);
        });
        return view;
    }

}
