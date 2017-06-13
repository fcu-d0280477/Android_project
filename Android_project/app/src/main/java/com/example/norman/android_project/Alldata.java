package com.example.norman.android_project;


import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import java.util.logging.LogRecord;

public class Alldata extends AppCompatActivity {



    private DataArrayAdapter adapter = null;
    private static final int LIST_DATAS = 1;

    private  Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LIST_DATAS: {
                    List<Data> datas = (List<Data>)msg.obj;
                    refreshDataList(datas);
                    break;
                }
            }
        }
    };

    private void refreshDataList(List<Data> datas) {
        adapter.clear();
        adapter.addAll(datas);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        ListView alldatalist = (ListView)findViewById(R.id.alldatalist);

        DataArrayAdapter adapter = new DataArrayAdapter(this, new ArrayList<Data>());
        alldatalist.setAdapter(adapter);

        getDataFromFirebase();




/*
        Button button13 = (Button)findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Alldata.this , MainActivity.class);
                startActivity(intent);
            }

        });*/



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void getDataFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                // new FirebaseThread(dataSnapshot).start();
                new FirebaseThread(dataSnapshot ,handler , LIST_DATAS ).start();

/*
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String title = "";
                    String content = "";

                    for(DataSnapshot cc: ds.getChildren()) {
                        DataSnapshot dsTitle = cc.child("標題");
                        String t = (String)dsTitle.getValue();
                        if(t != null) {
                            title = t;
                        }
                        DataSnapshot dsContent = cc.child("內容");
                        String c = (String)dsContent.getValue();
                        if(c != null) {
                            content = c;
                        }
                    }
                    Log.v("AdoptPet", title +";"+content);


                    DataSnapshot dsSName = ds.child("標題");

                    String shelterName = (String)dsSName.getValue();

                    Log.v("AdoptPet", shelterName + ";" );
                }


               /* for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    DataSnapshot dsSName = ds.child("shelter_name");
                    DataSnapshot dsAKind = ds.child("animal_kind");
                    String shelterName = (String)dsSName.getValue();
                    String kind = (String)dsAKind.getValue();
                    Log.v("AdoptPet", shelterName + ";" + kind);
                }*/


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("AdoptPet", databaseError.getMessage());
            }
        });
    }





}
