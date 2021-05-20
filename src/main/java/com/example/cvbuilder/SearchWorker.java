package com.example.cvbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchWorker extends AppCompatActivity {

    RecyclerView WorkerRecyclerView;
    WorkerAdapter myAdapter;
    DatabaseReference mRef;
    Worker worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_worker);

        WorkerRecyclerView = findViewById(R.id.worker_recycler_view);
        worker = new Worker();

        WorkerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Worker> options =
                new FirebaseRecyclerOptions.Builder<Worker>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Worker"), Worker.class)
                        .build();

        myAdapter = new WorkerAdapter(options, this);
        WorkerRecyclerView.setAdapter(myAdapter);

        // Read from the database
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    worker = dataSnapshot.getValue(Worker.class);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }
    }