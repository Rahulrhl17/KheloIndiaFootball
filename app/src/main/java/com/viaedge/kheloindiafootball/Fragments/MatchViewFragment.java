package com.viaedge.kheloindiafootball.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.viaedge.kheloindiafootball.Adapters.MatchPager;
import com.viaedge.kheloindiafootball.R;

import butterknife.ButterKnife;


public class MatchViewFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    ViewPager matchViewPager;
    MatchPager adapter;
    public MatchViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_view, container, false);
        ButterKnife.bind(view);
        tabLayout = view.findViewById(R.id.tabLayout);
        matchViewPager = view.findViewById(R.id.matchViewPager);
        adapter = new MatchPager(getActivity().getSupportFragmentManager(),tabLayout.getTabCount());
        matchViewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(matchViewPager);
        matchViewPager.setCurrentItem(1);
        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        matchViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
