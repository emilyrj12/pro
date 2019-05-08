package com.example.tm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    EditText e1,e2;
    String name,pass;
    Button b1;
    Cursor c;
    StringBuffer bf;
    Spinner sp;
    public static final String EXTRA_MESSAGE = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        b1=(Button)findViewById(R.id.b2);
       /* sp=(Spinner)findViewById(R.id.sp) ;
        ArrayAdapter <CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.usertype,R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);*/
        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=e1.getText().toString();
                pass=e2.getText().toString();
                //String item=sp.getSelectedItem().toString();
                if(name.equals("admin")&&pass.equals("admin"))
                {
                    Intent i=new Intent(Login.this,Admin_home.class);
                    startActivity(i);
                }
                else
                {
                c= db.rawQuery(" SELECT * FROM "+ DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_2 + " =? and " + DatabaseHelper.COL_5 + " =? ",new String[]{name,pass});

                if( c.getCount()!=0) {
                    if (c.getCount() > 0) {

                        c.moveToNext();

                        //Toast.makeText(Login.this, "Welcome", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(Login.this,userhome.class);
                        i.putExtra(EXTRA_MESSAGE,name);
                        startActivity(i);

                    }
                }

                else
                    {
                    Toast.makeText(Login.this, "sorry..!!", Toast.LENGTH_LONG).show();

                }}

            }

        });
       /* FloatingActionButton fab = findViewById(R.id.fab);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if(id==R.id.Login)
        {
            return true;
        }
        if (id==R.id.home)
        {
            Intent i=new Intent(Login.this,MainActivity.class);
            startActivity(i);
        }
        if (id==R.id.signup)
        {
            Intent i=new Intent(Login.this,signup.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
