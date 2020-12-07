package com.example.zadaca_lv7_fragmenti;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class firstMessageFragment extends Fragment {

    private static TextView tvFirstMessage;

    public static firstMessageFragment newInstance(){
        Log.d("TAG","FirstMessageFragment");
        return new firstMessageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFirstMessage=view.findViewById(R.id.tvFirstMessage);
    }

    public static void setMessage(String message) {
        if (tvFirstMessage != null) {
            tvFirstMessage.setText(!message.trim().isEmpty() ? message : "...");
        }
    }

}