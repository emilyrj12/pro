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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class userhome extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    TextView name,address,phone;
    DatabaseHelper mDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
        Intent intent = getIntent();
        String email = intent.getStringExtra(Login.EXTRA_MESSAGE);
        name = (TextView) this.findViewById(R.id.t1);
        address = (TextView) this.findViewById(R.id.t2);
        phone = (TextView) this.findViewById(R.id.t3);
        mDBHlpr = new DatabaseHelper(this); //<<<< get Instance of DatbaseHelper
        cursor = mDBHlpr.getUserInfo(email); //<<< get the Cursor according to email
        if (cursor.moveToFirst()) {
            name.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2)));
            address.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3)));
            phone.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4)));

        } else {
            // HANDLE NO DATA THAT MATCHES WHERE CLAUSE
            name.setText("Sorry No User found that has email as :- " + name);
        }
        cursor.close(); //<<<< DONE WITH THE CURSOR SO CLOSE IT









        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*switch(item.getItemId()){
            case R.id.Login:
                Intent intent=new Intent(this,Login.class);
                this.startActivity(intent);
                break;
            case R.id.signup:
                Intent intent1=new Intent(this,signup.class);
                this.startActivity(intent1);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            return true;
        }
*/
        int id=item.getItemId();

        if(id==R.id.profile)
        {
            return true;
        }
        if (id==R.id.Destinations)
        {
            Intent i=new Intent(userhome.this,Destinatons.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
