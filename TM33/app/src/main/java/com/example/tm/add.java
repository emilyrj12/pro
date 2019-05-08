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
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class add extends AppCompatActivity {
    Button b1,b2;
    ListView list;
    String place[],description[],district[];
    int fid[];
    Cursor c;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper bb;

    ArrayList<dataModel> dataModels;
    private static CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
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
        b1=(Button)findViewById(R.id.addfood);
        b2=(Button)findViewById(R.id.addcateg);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        /*list=(ListView)findViewById(R.id.foodList);
        c=db.query(DatabaseHelper.TABLE_PLACE,// Selecting Table
                new String[]{DatabaseHelper.KEY_PLACE_ID, DatabaseHelper.KEY_DISTRICT,DatabaseHelper.KEY_PLACE, DatabaseHelper.KEY_DESCR },//Selecting columns want to query
                null,
                null,//Where clause
                null, null, null);
//        c.moveToNext();
        district=new String[c.getCount()];
        fid=new int[c.getCount()];
        place=new String[c.getCount()];
        description=new String[c.getCount()];
        if(c.getColumnCount()>0) {
            int i = 0;
            do {
                c.moveToNext();
                fid[i]=c.getInt(0);
                district[i] = c.getString(1);
                place[i] = c.getString(2);
                description[i] = c.getString(3);
                i = i + 1;
            } while (i < c.getCount());
        }

        dataModels= new ArrayList<>();
        for(int i=0;i<place.length;i++) {
            dataModels.add(new dataModel(district[i],place[i], description[i]));
        }



        adapter= new CustomAdapter(dataModels,getApplicationContext());

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel dataModel= dataModels.get(position);
                String plac=place[position];
                Intent i = new Intent(add.this,updateitem.class);
                i.putExtra("id",fid);
                i.putExtra("pos",position);
                i.putExtra("item",plac);
                startActivity(i);

                Snackbar.make(view, dataModel.getDistrict()+"\n"+dataModel.getPlace()+"\n"+dataModel.getDescr(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(add.this,add_item.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(add.this, adddist.class);
                startActivity(i);
            }
        });
    }

}
