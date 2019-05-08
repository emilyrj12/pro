package com.example.tm;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;

public class adddist extends AppCompatActivity {
    EditText e1;
    Button b1,b2;
    //SQLiteDatabase db;
   // SQLiteOpenHelper openHelper;
    //DatabaseHelper bb;
//SQLiteDatabase db;
DatabaseHelper sqliteHelper;
   // DatabaseHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddist);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
       // sqliteHelper = new DatabaseHelper(this);
        sqliteHelper = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.e1);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String district=e1.getText().toString();
                if(district.isEmpty()){
                    Snackbar.make(b1, "field is empty ", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                  // sqliteHelper.adddist(district);
                   // bb.adddist(district);
                    sqliteHelper.adddist(district);
                    Snackbar.make(b1, "District Added successfully! ", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i=new Intent(addcategory.this,Admin_home.class);
                Intent i = new Intent(adddist.this, Admin_home.class);
                startActivity(i);
                finish();
            }
        });
    }

}
