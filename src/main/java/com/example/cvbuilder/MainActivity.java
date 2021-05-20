package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CVBuilder(View view){
        startActivity(new Intent(this, CVBuilder.class));
    }

    public void EditCV(View view){
        startActivity(new Intent(this, WorkerAuthentication.class));
    }

    public void SearchWorker(View view){
        startActivity(new Intent(this, SearchWorker.class));
    }
}
