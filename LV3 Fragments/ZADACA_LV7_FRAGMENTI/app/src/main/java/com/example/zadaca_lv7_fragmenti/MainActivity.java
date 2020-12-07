package com.example.zadaca_lv7_fragmenti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FirstFragment firstFragment;
    private firstMessageFragment messageFragment;
    private FragmentManager manager;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getSupportFragmentManager();
        //setUpFragments();

        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);

        setUpPager();

    }

    /*private void setUpFragments(){
        messageFragment=new firstMessageFragment();
        firstFragment=new FirstFragment();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id., );
        fragmentTransaction.add(R.id., );
        fragmentTransaction.commit();

    }*/

    private void setUpPager(){
        PageSlideAdapter adapter = new PageSlideAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setPageTransformer(false, new SlideAnimation()); //samo dodaje efekat pri pomicanju tab-a
    }

}
