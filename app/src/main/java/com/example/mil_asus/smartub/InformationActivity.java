package com.example.mil_asus.smartub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mil_ASUS on 23/1/2018.
 */

public class InformationActivity extends AppCompatActivity {

    RecyclerView rv;

    List<SmartubeData> smartubeDatos;

    Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        rv = (RecyclerView) findViewById(R.id.recyclerView_Information);

        rv.setLayoutManager(new LinearLayoutManager(this));

        smartubeDatos = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(smartubeDatos);

        rv.setAdapter(adapter);

        database.getReference().child("smartub_data").getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                smartubeDatos.removeAll(smartubeDatos);
                for (DataSnapshot snapshot:dataSnapshot.getChildren()
                     ) {
                    SmartubeData smartubeData = snapshot.getValue(SmartubeData.class);
                    smartubeDatos.add(smartubeData);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



}


