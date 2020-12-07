package com.example.zadacalv6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ClickListener {

    private CustomAdapter customAdapter;
    private List<String> dataList;
    private static final String TAG="CustomAdapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecycleViewData();
        setupRecycleView();
    }

    private void setupRecycleView(){
        RecyclerView recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        customAdapter=new CustomAdapter(dataList, this);
        recycler.setAdapter(customAdapter);
    }

    private void setupRecycleViewData(){
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

    @Override
    public void onButtonClick(View view) {
        EditText editStudent = (EditText) findViewById(R.id.ed_student);
        String studentName= editStudent.getText().toString();
        if(studentName.length()==0){
            makeToast();
            return;
        }
        customAdapter.addCell(customAdapter.getItemCount(),studentName);
    }

    @Override
    public void onImageClick(int position) {
        customAdapter.removeCell(position);
    }

    public void makeToast(){
        Toast.makeText(this,"Please enter student name",Toast.LENGTH_SHORT).show();
    }


}