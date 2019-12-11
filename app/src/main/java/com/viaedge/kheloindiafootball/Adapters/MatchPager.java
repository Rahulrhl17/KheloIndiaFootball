package com.viaedge.kheloindiafootball.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.viaedge.kheloindiafootball.Fragments.HighlightsFragment;
import com.viaedge.kheloindiafootball.Fragments.LineUpFragment;
import com.viaedge.kheloindiafootball.Fragments.MatchLineUp;
import com.viaedge.kheloindiafootball.Fragments.MultimediaFragment;

public class MatchPager extends FragmentPagerAdapter {
    private int tabCount;

    public MatchPager(@NonNull FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MatchLineUp matchLineUp = new MatchLineUp();
                return matchLineUp;
            case 1:
                HighlightsFragment highlightsFragment = new HighlightsFragment();
                return highlightsFragment;
            case 2:
                MultimediaFragment multimediaFragment = new MultimediaFragment();
                return multimediaFragment;
                default:
                    return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        switch (position) {
            case 0:
                return "Line Up";
            case 1:
                return "Highlights";
            case 2:
                return "Multimedia";

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
