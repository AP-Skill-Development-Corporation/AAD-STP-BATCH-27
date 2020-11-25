package com.muneiah.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView active_tv,deaths_tv,recovered_tv,country_tv,date_tv,confirmed_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        active_tv=findViewById(R.id.active);
        deaths_tv=findViewById(R.id.deaths);
        recovered_tv=findViewById(R.id.recovered);
        confirmed_tv=findViewById(R.id.confirmed);
        country_tv=findViewById(R.id.country);
        date_tv=findViewById(R.id.date);
    }
}