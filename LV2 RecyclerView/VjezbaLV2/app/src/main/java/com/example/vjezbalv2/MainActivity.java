package com.example.vjezbalv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView recycler;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
    }

    private void setupRecycler(){
        this.recycler=findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }


    private void setupRecyclerData(){
        List<String> data=new ArrayList<>();
        data.add("Ana");
        data.add("Marko");
        data.add("Pero");

        adapter.addData(data);
    }

    public void addCell(View view){
        adapter.addNewCell("Petra",1);
    }

    public void removeCell(View view){
        adapter.removeCell(0);
    }

    @Override
    public void OnNameClick(int position) {
        Toast.makeText(this,"position"+ position,Toast.LENGTH_SHORT).show();
    }
}