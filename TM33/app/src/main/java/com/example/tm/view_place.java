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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class view_place extends AppCompatActivity {
    String District,Name[];
    Cursor v;
    int pos;
    TextView t1,t2,t3,t4,t5;
    Button b1;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper bb;
    ListView a1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place);
        a1=(ListView)findViewById(R.id.namelist);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        Intent i=getIntent();
        pos=i.getIntExtra("v",0);
        District=i.getStringExtra("Name");
       // Toast.makeText(getApplicationContext(), District, Toast.LENGTH_LONG).show();
        /*v= db.query(DatabaseHelper.TABLE_NAME,// Selecting Table
                new String[]{DatabaseHelper.COL_1, DatabaseHelper.COL_2, DatabaseHelper.COL_3,DatabaseHelper.COL_4,DatabaseHelper.COL_5 },//Selecting columns want to query
                DatabaseHelper.COL_2 + "=?",
                new String[]{District},//Where clause
                null, null, null);
        v.moveToNext();*/
        v= db.query(DatabaseHelper.TABLE_PLACE,// Selecting Table
                new String[]{DatabaseHelper.KEY_PLACE_ID, DatabaseHelper.KEY_DISTRICT, DatabaseHelper.KEY_PLACE,DatabaseHelper.KEY_DESCR ,DatabaseHelper.KEY_IMG},//Selecting columns want to query
                DatabaseHelper.KEY_DISTRICT + "=?",
                new String[]{District},//Where clause
                null, null, null);
       // v.moveToNext();
        Name=new String[v.getCount()];
        int j=0;
        do{
            v.moveToNext();
            Name[j]=v.getString(2);
            j=j+1;
        }while (j<v.getCount());


        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Name);
        a1.setAdapter(ad);
        a1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(view_place.this,pldetail.class);
                i.putExtra("v",position);
                i.putExtra("Name",Name[position]);
                startActivity(i);
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
