package com.example.lv4_zadaca_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
    }

    private void setUpUI(){
        searchBox=(EditText) findViewById(R.id.editText);
        Button searchButton=(Button) findViewById(R.id.searchBtn);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpAPICall();
            }
        });
    }

    private void setUpRecycler(List<Product> products){
        if(products.isEmpty()){
            Log.d("data:","data:"+products);
            Toast.makeText(this,"Please check your input",Toast.LENGTH_SHORT).show();
            return;
        }
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter customAdapter=new CustomAdapter(products);
        recyclerView.setAdapter(customAdapter);
    }


    private void setUpAPICall() {
        String brand=searchBox.getText().toString();
        if(brand.equals("")){
            Toast.makeText(this,"Please check your input",Toast.LENGTH_SHORT).show();
            Log.d("Text",brand);
            return;
        }
        Call<List<Product>> apiCall = NetworkUtils.getAPIInterface().getProductsByBrand(brand);
        apiCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful() && response.body() != null){
                    setUpRecycler(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }

}
