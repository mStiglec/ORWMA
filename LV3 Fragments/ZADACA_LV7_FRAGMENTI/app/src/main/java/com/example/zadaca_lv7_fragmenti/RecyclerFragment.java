package com.example.zadaca_lv7_fragmenti;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment implements onClickListener {

    private Button addButton;
    private EditText edAddText;
    private List<String> dataList;
    private RecyclerAdapter adapter;

    public static RecyclerFragment newInstance(){
        return new RecyclerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerViewData();
        setupRecyclerView();

        addButton=view.findViewById(R.id.AddStudent);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonAdd();
            }
        });
    }

    private void setupRecyclerViewData(){
        dataList=new ArrayList<>();
        dataList.add("Student1");
        dataList.add("Student2");
        dataList.add("Student3");
        dataList.add("Student4");
        dataList.add("Student6");
        dataList.add("Student7");
        dataList.add("Student8");
        dataList.add("Student9");
        dataList.add("Student10");
    }

    private void setupRecyclerView(){
        RecyclerView recycler =(RecyclerView) getActivity().findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter=new RecyclerAdapter(dataList,this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onButtonAdd() {
        edAddText=(EditText) getActivity().findViewById(R.id.ed_student);
        String studentName= edAddText.getText().toString();
            if(studentName.length()==0){
                makeToast();
                return;
            }
            adapter.addCell(adapter.getItemCount(),studentName);
    }


    @Override
    public void onButtonDelete(int position) {
        adapter.removeCell(position);
    }

    public void makeToast(){
        Toast.makeText(getActivity(),"Please enter student name",Toast.LENGTH_SHORT).show();
    }
}