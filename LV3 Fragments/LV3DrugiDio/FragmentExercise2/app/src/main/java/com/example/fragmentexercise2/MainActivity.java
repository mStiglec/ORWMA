package com.example.fragmentexercise2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private static final String TAG="MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
        setUpPager();
    }

    private void setUpPager() {
        Log.d(TAG,"ScreenSlidePagerAdapter()");
        ScreenSlidePagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        Log.d(TAG,"setAdapter()");
        mViewPager.setAdapter(adapter);
        Log.d(TAG,"setUpWithViewPager()");
        mTabLayout.setupWithViewPager(mViewPager);

        //mViewPager.setPageTransformer(false, new DepthPageTransformer()); //samo dodaje efekat pri pomicanju tab-a
    }
}
