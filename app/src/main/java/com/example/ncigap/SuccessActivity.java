package com.example.ncigap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState); // calls the onCreate method of the parent class,
        setContentView(R.layout.activity_success); // specifies which layout file should be used to define the UI of the activity. converts the XML code into visual elements

        back = (Button) findViewById(R.id.backHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackHome();
            }
        });
    }

    public void goBackHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
