package com.example.Zadaca1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.content.res.Resources;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;


public class MainActivity extends AppCompatActivity{

    ImageView image1;
    ImageView image2;
    ImageView image3;
    Button btnInspiration;
    Button btnEditDescription;
    Random rand=new Random();
    EditText text;
    RadioButton firstRadioBtn,secondRadioBtn,thirdRadioBtn;
    TextView firstDescription,secondDescription,thirdDescription;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeUI();
    }

    private void InitializeUI(){
        getViewObjects();

        this.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setVisibility(View.GONE);

            }
        });
        this.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image2.setVisibility(View.GONE);
            }
        });
        this.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image3.setVisibility(View.GONE);
            }
        });
        this.btnInspiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Resources res=getResources();
                    String[] facts=res.getStringArray(R.array.InterestingFacts);
                    int num=rand.nextInt(3);
                    DisplayToast(facts[num]);

            }
        });
        this.btnEditDescription.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstRadioBtn.isChecked()){
                    firstDescription.setText(text.getText().toString());
                }else if(secondRadioBtn.isChecked()){
                    secondDescription.setText(text.getText().toString());
                }else if(thirdRadioBtn.isChecked()){
                    thirdDescription.setText(text.getText().toString());
                }else{
                    DisplayToast("Please check radio button on bottom");
                }
            }
        }));

    }

    private void DisplayToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void getViewObjects(){
        this.image1=(ImageView) findViewById(R.id.FirstPicture);
        this.image2=(ImageView) findViewById(R.id.SecondPicture);
        this.image3=(ImageView) findViewById(R.id.ThirdPicture);
        this.btnInspiration=(Button) findViewById(R.id.Inspiration);
        this.btnEditDescription=(Button) findViewById(R.id.btnEditDescription);
        this.text=(EditText) findViewById(R.id.EditDescription);
        this.firstRadioBtn=(RadioButton) findViewById(R.id.FirstRadioButton);
        this.secondRadioBtn=(RadioButton) findViewById(R.id.SecondRadioButton);
        this.thirdRadioBtn=(RadioButton) findViewById(R.id.ThirdRadioButton);
        this.firstDescription=(TextView) findViewById(R.id.FirstDescription);
        this.secondDescription=(TextView) findViewById(R.id.SecondDescription);
        this.thirdDescription=(TextView) findViewById(R.id.ThirdDescription);
        this.group=(RadioGroup) findViewById(R.id.Radiogroup);
    }

}