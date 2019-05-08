package com.example.tm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.sql.Blob;

public class pldetail extends AppCompatActivity {
    String Name;
    Cursor c;
    int pos;
    TextView t1,t2,t3,t4,t5;
    Button b1;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    DatabaseHelper bb;
    ImageView imag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pldetail);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        imag=(ImageView)findViewById(R.id.imag);
        b1=(Button)findViewById(R.id.b1);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        Intent i=getIntent();
        pos=i.getIntExtra("v",0);
        Name=i.getStringExtra("Name");


        c= db.query(DatabaseHelper.TABLE_PLACE,// Selecting Table
                new String[]{DatabaseHelper.KEY_PLACE_ID, DatabaseHelper.KEY_DISTRICT, DatabaseHelper.KEY_PLACE,DatabaseHelper.KEY_DESCR,DatabaseHelper.KEY_IMG },//Selecting columns want to query
                DatabaseHelper.KEY_PLACE + "=?",
                new String[]{Name},//Where clause
                null, null, null);
        c.moveToNext();


       // t1.setText("id : "+c.getString(0));
        t1.setText("District : "+c.getString(1));
        t2.setText("Place : "+c.getString(2));
        t3.setText("About : "+c.getString(3));
         byte[] im=c.getBlob(4);
        // byte[] im = c.getBlob(c.getColumnIndex(bb.KEY_IMG));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(im);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        imag.setImageBitmap(bitmap);
       // imag.setImageBitmap(getImageFromBLOB(object.getBlob(object.getColumnIndex("KEY_IMG"))));


          //imag.setImageResource(im);
        //byte[] image = cursor.getBlob(3);


    }
    public static Bitmap getImageFromBLOB(byte[] mBlob)
    {
        byte[] bb = mBlob;
        return BitmapFactory.decodeByteArray(bb, 0, bb.length);
    }
}
