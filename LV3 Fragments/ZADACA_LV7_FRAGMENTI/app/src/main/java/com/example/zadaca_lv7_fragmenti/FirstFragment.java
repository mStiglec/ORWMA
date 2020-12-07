package com.example.zadaca_lv7_fragmenti;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class FirstFragment extends Fragment implements TextWatcher {

    private static String message;
    private Button submitButton;
    private EditText editMessage;


    public static FirstFragment newInstance(){
        Log.d("TAG","FirstFragment");
        return new FirstFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submitButton=view.findViewById(R.id.btSubmit);
        editMessage=view.findViewById(R.id.edMessage);
        setUpListeners();
    }

    private void setUpListeners(){
        editMessage.addTextChangedListener(this);
        ViewPager viewPager =(ViewPager) getActivity().findViewById(R.id.viewPager);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    viewPager.setCurrentItem(1); //poziva getItem tj. stvara se nova instanca n-tog elementa
                    firstMessageFragment.setMessage(message);
            }
        });

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
            message=s.toString();
    }

}