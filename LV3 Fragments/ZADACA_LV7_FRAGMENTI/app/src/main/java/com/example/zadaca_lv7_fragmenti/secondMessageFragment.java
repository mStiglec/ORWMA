package com.example.zadaca_lv7_fragmenti;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class secondMessageFragment extends Fragment {

    private static final String BUNDLE_MESSAGE = "message";

    public static secondMessageFragment newInstance(String message){
        Log.d("dada","SecondFragment "+message);
        secondMessageFragment fragment=new secondMessageFragment();

        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE, message);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String tab=getArguments().getString(BUNDLE_MESSAGE);

        if(tab.equals("text")) {
            return inflater.inflate(R.layout.fragment_second_message, container, false);
        }else{
            return inflater.inflate(R.layout.second_fragment_image, container, false);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}

