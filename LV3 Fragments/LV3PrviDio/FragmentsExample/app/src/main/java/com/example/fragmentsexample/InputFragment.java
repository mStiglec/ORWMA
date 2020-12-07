package com.example.fragmentsexample;

import android.content.Context;
import android.media.MediaCodecList;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment implements TextWatcher {

    private String mMessageString = "...";
    private EditText mEditText;
    private Button mSubmitButton;

    private static final String TAG = "MyActivity";

    private ButtonClickListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditText = view.findViewById(R.id.edMessage);
        mSubmitButton = view.findViewById(R.id.btSubmit);
        setUpListeners();
    }

    private void setUpListeners() {
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onButtonClick(mMessageString);
                }
            }
        });
        //Log.d(TAG,"addTextChangedListener in setUpListeners");
        mEditText.addTextChangedListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        // onAttach() poziva se kada se fragment poveze s kontekstom tj nakon metode
        // fragmentTransaction.add()
        //Log.d(TAG,"onAttach");
        super.onAttach(context);
        if(context instanceof ButtonClickListener){
            mListener = (ButtonClickListener) context;
        }
    }

    @Override
    public void onDetach() {
        //Log.d(TAG,"onDetach()");
        super.onDetach();
        mListener = null;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        //Log.d(TAG,"afterTextChanged()");
        mMessageString = s.toString();
    }
}