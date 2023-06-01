package com.example.ncigap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    // initializing variables
    EditText nameIn, stuffIn;
    Button butSubmit;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // called when the activity is being created, responsible for setting up the initial state of the activity
        super.onCreate(savedInstanceState); // calls the onCreate method of the parent class,
        setContentView(R.layout.activity_main); // specifies which layout file should be used to define the UI of the activity. converts the XML code into visual elements

        // assigns variables of the values from the xml file
        nameIn = findViewById(R.id.nameInput);
        stuffIn = findViewById(R.id.userInput);
        butSubmit = findViewById(R.id.submit);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        // command for the submit button
        butSubmit.setOnClickListener(new View.OnClickListener() {
            @Override // overriding the onClick() method
            public void onClick(View view) {
                System.out.println("ITS WORKING?");
                addData();
                System.out.println("ITS WORKING?");
                progressBar.setVisibility(ProgressBar.VISIBLE);
            }
        });
    }

    public void addData() {
        String name = nameIn.getText().toString();
        String data = stuffIn.getText().toString();

        /* creating a HTTP request
        Request.Method.POST = specifies that you want to make a POST request to the server
        new Response.Listener<String>() { ... } = defines an anonymous inner class that implements
        the Response.Listener interface.

        you create an "Intent" to navigate to the SuccessActivity using the getApplicationContext()
        startActivity(intent) starts the SuccessActivity so it become visible to the user
        */
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxkndUgq4XL6JLhLZw2HkyLb_m-k-_mw_S-YOFgx8ifkUDPtennx8PzcO8XKriJWb9idw/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() { //handles the response received from the server when the request is successful
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String>getParams(){ //getParams() does not take any parameters
                Map<String, String> params = new HashMap<>(); //
                params.put("action", "addData");
                params.put("vName", name);
                params.put("vData", data);

                return params;
            }
        };

        int socketTimeOut = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}