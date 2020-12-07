package com.example.fragmentexercise2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 3;
    private static final String TAG="ADAPTER";


    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Log.d(TAG,"getItem()");
        //poziva se staticki konstruktor preko klase pagefragmenta i vrati se fragment
        return ScreenSlidePageFragment.newInstance("This is fragment #" + (position + 1));
    }

    @Override
    public int getCount() {
        Log.d(TAG,"getCount()");
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(TAG,"getPageTitle()");
        return "Tab #" + (position + 1);
    }
}
