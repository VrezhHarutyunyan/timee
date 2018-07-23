package com.example.cybertech2.timee.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.cybertech2.timee.Fragments.AllFragment;
import com.example.cybertech2.timee.Fragments.HumanFragment;
import com.example.cybertech2.timee.Fragments.Tab1Fragment;
import com.example.cybertech2.timee.Fragments.Tab2Fragment;
import com.example.cybertech2.timee.Fragments.Tab3Fragment;
import com.example.cybertech2.timee.Fragments.TabFragment;
import com.example.cybertech2.timee.Fragments.UnknownFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTubs;

    public PagerAdapter(FragmentManager fm, int numberOfTubs) {
        super(fm);
        this.numberOfTubs = numberOfTubs;
}

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                AllFragment allFragment = new AllFragment();
                return allFragment;
            case 1:
                HumanFragment humanFragment = new HumanFragment();
                return humanFragment;
            case 2:
                UnknownFragment unknownFragment = new UnknownFragment();
                return unknownFragment;
            case 3:
               TabFragment tabFragment = new TabFragment();
                return tabFragment;
            case 4:
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                return tab1Fragment;
            case 5:
                Tab2Fragment tab2Fragment = new Tab2Fragment();
                return tab2Fragment;
            case 6:
                Tab3Fragment tab3Fragment = new Tab3Fragment();
                return tab3Fragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTubs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Բոլորը";
            case 1:
                return "Մարդը";
            case 2:
                return "Անհայտ";
            case 3:
                return "Առօրյա";
            case 4:
                return "Առօրյա";
            case 5:
                return "Առօրյա";
            case 6:
                return "Առօրյա";
         default:
             return null;
        }
    }
}
