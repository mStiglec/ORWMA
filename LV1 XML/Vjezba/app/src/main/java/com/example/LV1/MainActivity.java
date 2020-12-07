package com.example.LV1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHeaderMessage;
    Button bDestroyAllHumans, bRestoreAllHumans, bIgnoreAllHumans;
    EditText num;
    private static final String AGE_ENTER="You entered your age";
    private static final String TAG="MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Before setting content view.");
        setContentView(R.layout.activity_main);
        Log.d(TAG, "After setting content view.");
        initializeUI();
    }

    private void initializeUI() {
        this.num=(EditText) findViewById(R.id.Number);
        this.tvHeaderMessage = (TextView) findViewById(R.id.tvHeaderMessage);
        this.bDestroyAllHumans = (Button) findViewById(R.id.bDestroyAllHumans);
        this.bRestoreAllHumans = (Button) findViewById(R.id.bRestoreAllHumans);
        this.bIgnoreAllHumans = (Button) findViewById(R.id.bIgnoreAllHumans);
        this.bDestroyAllHumans.setOnClickListener(this); // Activity implements the interface
        this.bRestoreAllHumans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHeaderMessage.setText(R.string.bRestoreAllHumansText);
            }
        });
    }

    public void customOnClick(View view){
        this.tvHeaderMessage.setText(R.string.bIgnoreAllHumansText);
    }

    public void onClick(View view){
        this.tvHeaderMessage.setText(AGE_ENTER);
        this.DisplayToast(AGE_ENTER);
    }

    private void DisplayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}