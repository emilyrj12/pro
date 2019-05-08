package com.example.tm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class details extends AppCompatActivity {
    String Name;
    Cursor c;
    int pos;
    TextView t1,t2,t3,t4,t5;
    Button b1;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        b1=(Button)findViewById(R.id.b1);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        Intent i=getIntent();
        pos=i.getIntExtra("v",0);
        Name=i.getStringExtra("Name");


        c= db.query(DatabaseHelper.TABLE_NAME,// Selecting Table
                new String[]{DatabaseHelper.COL_1, DatabaseHelper.COL_2, DatabaseHelper.COL_3,DatabaseHelper.COL_4,DatabaseHelper.COL_5 },//Selecting columns want to query
                DatabaseHelper.COL_2 + "=?",
                new String[]{Name},//Where clause
                null, null, null);
        c.moveToNext();


        t1.setText("id : "+c.getString(0));
        t2.setText("Name : "+c.getString(1));
        t3.setText("Address : "+c.getString(2));
        t4.setText("phone : "+c.getString(3));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(details.this,Admin_home.class);
                startActivity(i);
                finish();
            }
        });
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
    }

}
