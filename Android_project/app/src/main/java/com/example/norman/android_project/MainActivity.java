package com.example.norman.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , select.class);
                startActivity(intent);
            }
        });



        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , website.class);
                startActivity(intent);
            }
        });




        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , law.class);
                startActivity(intent);
            }
        });


        Button button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , BMI.class);
                startActivity(intent);
            }
        });


        Button button16 = (Button)findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , Alldata.class);
                startActivity(intent);
            }
        });


/*

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                jumpToLayoutSelect();

            }


        });



        Button button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                jumpToLayoutWebsite();
            }
        });





       /* Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                jumpToLayoutLaw();
            }
        });
        */




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


/*

    public void jumpToLayoutWebsite(){

        setContentView(R.layout.layout_website);

        Button button4= (Button)findViewById(R.id.button4);

        button4.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v) {

                // TODO Auto-generated method stub

                jumpToContentMain();

            }

        });

    }

    public void jumpToLayoutLaw(){

        setContentView(R.layout.layout_website);

        Button button5= (Button)findViewById(R.id.button5);

        button5.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v) {

                // TODO Auto-generated method stub

                jumpToContentMain();

            }

        });

    }


    public void jumpToLayoutSelect(){

        setContentView(R.layout.layout_select);

        Button button6= (Button)findViewById(R.id.button6);

        button6.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v) {

                // TODO Auto-generated method stub

                jumpToContentMain();

            }

        });

    }


    public void jumpToContentMain(){
        setContentView(R.layout.activity_main);


        Button button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                jumpToLayoutWebsite();
            }
        });






        });



        

        });

       */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
