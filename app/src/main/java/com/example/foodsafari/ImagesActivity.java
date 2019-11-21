package com.example.logintest;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<Upload_Food> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //mProgressCircle = findViewById(R.id.progress_circle);

        mUploads = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Res_owner_menu").child(Constant.res_owner_pass);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload_Food upload = postSnapshot.getValue(Upload_Food.class);
                    mUploads.add(upload);
                }

                mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);

                mRecyclerView.setAdapter(mAdapter);
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });
    }
}