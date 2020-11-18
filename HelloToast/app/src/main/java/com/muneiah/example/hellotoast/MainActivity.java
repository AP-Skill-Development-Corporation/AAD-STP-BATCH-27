package com.muneiah.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView label_text;
int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label_text=findViewById(R.id.tv);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Welcome android world", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {

    }
}