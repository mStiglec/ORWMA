package com.example.lv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView recycler;
    private CustomAdapter customAdapter;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecycleViewData();
        setupRecycleView();
    }

    private void setupRecycleView(){
        recycler=findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        customAdapter=new CustomAdapter(dataList, this);
        recycler.setAdapter(customAdapter);
    }

    private void setupRecycleViewData(){
        dataList=new ArrayList<>();
        dataList.add("Anna");
        dataList.add("Marko");
        dataList.add("Mislav");
        dataList.add("marta");
    }

    @Override
    public void onNameClick(int position) {
            customAdapter.removeCell(position);
    }
}