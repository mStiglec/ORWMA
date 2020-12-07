package com.example.zadaca_lv7_fragmenti;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.Random;

public class PageSlideAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_OF_SLIDES=5;
    FirstFragment firstFragment;

    public PageSlideAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        firstFragment=new FirstFragment();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        String tab=getRandomText();
        switch(position){
            case 0:
                Log.d("TAG","inputFrag"+position);
                return FirstFragment.newInstance();
            case 1:
                Log.d("TAG","FirstFrag"+position);
                return firstMessageFragment.newInstance();
            case 2:
                Log.d("TAG","RecyclerFrag" +position);
                return RecyclerFragment.newInstance();
            case 3:
                Log.d("TAG","FirstMessageFrag"+position);
                return secondMessageFragment.newInstance("text");
            default:
                Log.d("TAG","SecondMessageFrag"+position);
                return secondMessageFragment.newInstance(tab);

        }
    }

    @Override
    public int getCount() {
        return NUM_OF_SLIDES;
    }

    public CharSequence getPageTitle(int position) {
        return "Tab #" + (position + 1);
    }

    private String getRandomText(){
        Random rand=new Random();
        String tabs[]={"text","picture"};
        return tabs[rand.nextInt(2)];
    }

}
