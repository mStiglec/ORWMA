package com.example.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ButtonClickListener {

    private MessageFragment mMessageFragment;
    private InputFragment mInputFragment;
    private FragmentManager mFragmentManager; //upravljac fragmentima

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        setUpFragments();
    }

    private void setUpFragments() {
        mMessageFragment = new MessageFragment();
        mInputFragment = new InputFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.firstFragment, mMessageFragment);
        fragmentTransaction.add(R.id.secondFragment, mInputFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onButtonClick(String message) {
        mMessageFragment.displayMessage(message);
    }
}