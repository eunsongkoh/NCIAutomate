package com.example.ncigap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    // initializing variables
    EditText nameIn, stuffIn;
    Button butSubmit;
    //ProgressBar progressBar;

    //progressBar.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calls the onCreate method of the parent class,
        setContentView(R.layout.activity_main);

        nameIn = findViewById(R.id.nameInput);
        stuffIn = findViewById(R.id.userInput);
        butSubmit = findViewById(R.id.submit);
        //progressBar = findViewById(R.id.progressBar);

        butSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }

    public void addData(){
        String name = nameIn.getText().toString();
        String data = stuffIn.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST);

    }
}