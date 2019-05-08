package com.example.tm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class view extends AppCompatActivity {
    Button b1;
    ListView a1;
    String Name[];
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper bb;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
       b1=(Button)findViewById(R.id.button6);
       a1=(ListView)findViewById(R.id.namelist);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        //  User list = bb.getuser(new User(null, null, null, null));
        c=db.query(DatabaseHelper.TABLE_NAME,// Selecting Table
                new String[]{DatabaseHelper.COL_1, DatabaseHelper.COL_2, DatabaseHelper.COL_3, DatabaseHelper.COL_4,DatabaseHelper.COL_5},//Selecting columns want to query
                null,
                null,//Where clause
                null, null, null);

        Name=new String[c.getCount()];
        int i=0;
        do{
            c.moveToNext();
            Name[i]=c.getString(1);
            i=i+1;
        }while (i<c.getCount());


        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Name);
        a1.setAdapter(ad);
        a1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(view.this,details.class);
                i.putExtra("v",position);
                i.putExtra("Name",Name[position]);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(view.this,Admin_home.class);
                startActivity(i);
                finish();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
