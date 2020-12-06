package com.muneiah.example.studentdirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muneiah.example.studentdirectory.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
static StudentDataBase dataBase;
List<StudentEntity> list;
StudentEntity entity;
StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

dataBase= Room.databaseBuilder(this,StudentDataBase.class,"apssdc").allowMainThreadQueries().build();
    }

    public void saveData(View view) {
        entity=new StudentEntity();
        entity.setName(binding.editTextforname.getText().toString());
        entity.setId(binding.editTextTextforid.getText().toString());
        dataBase.studentDAO().insertData(entity);
        Toast.makeText(this, "Insert success :"+binding.editTextforname.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void retriveData(View view) {
        list=dataBase.studentDAO().retrivetData();
        adapter=new StudentAdapter(this,list);
        Toast.makeText(this, list.size()+" Total rows ", Toast.LENGTH_SHORT).show();
        binding.rec.setLayoutManager(new LinearLayoutManager(this));
        binding.rec.setAdapter(adapter);
    }
}