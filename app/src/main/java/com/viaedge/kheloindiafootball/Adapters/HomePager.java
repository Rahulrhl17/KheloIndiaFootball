package com.viaedge.kheloindiafootball.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.viaedge.kheloindiafootball.Fragments.FixturesFragment;
import com.viaedge.kheloindiafootball.Fragments.HomeFragment;
import com.viaedge.kheloindiafootball.Fragments.TeamFragment;

public class HomePager extends FragmentPagerAdapter {

    //integer to count number of tabs
    private int tabCount;

    //Constructor to the class
    public HomePager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                TeamFragment teamFragment = new TeamFragment();
                return teamFragment;
            case 2:
                FixturesFragment fixturesFragment = new FixturesFragment();
                return fixturesFragment;
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "My Team";
            case 2:
                return "Fixtures";

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return tabCount;
    }
}

