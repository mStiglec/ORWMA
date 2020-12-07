package com.example.fragmentexercise2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScreenSlidePageFragment extends Fragment {

    private static final String BUNDLE_MESSAGE = "message";
    private static final String TAG="FRAGMENT";

    private TextView mMessageTv;

    public static ScreenSlidePageFragment newInstance(String message){
        Log.d(TAG,"ScreenSlidePageFragment()");
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        //pravi fragment i vraca ga adapteru koji ga cuva kao i sve ostale
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView()");
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"onViewCreated()");
        mMessageTv = view.findViewById(R.id.tvMessage);
        setUpTextView();
    }

    private void setUpTextView() {
        Log.d(TAG,"setUpTextView()");
        String message = getString(R.string.hello_world);
        if (getArguments() != null){
            String argsMessage = getArguments().getString(BUNDLE_MESSAGE);
            if (argsMessage != null && !argsMessage.isEmpty()){
                message = argsMessage;
            }
        }
        mMessageTv.setText(message);
    }
}