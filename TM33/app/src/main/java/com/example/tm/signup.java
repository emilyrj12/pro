package com.example.tm;

import android.content.ContentValues;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    EditText name;
    EditText address;
    EditText phone;
    EditText password;
    EditText conpass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        openHelper = new DatabaseHelper(this);
        name = (EditText)findViewById(R.id.name);
        address = (EditText)findViewById(R.id.address);
        phone = (EditText)findViewById(R.id.phone);
        password = (EditText)findViewById(R.id.password);
        conpass=(EditText)findViewById(R.id.conpass);
        register = (Button)findViewById(R.id.button2);
        //AddData();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                if (name.getText().toString().equals(""))
                {
                    name.setError(" enter name");
                }
                else if (address.getText().toString().equals(""))
                {
                    address.setError("enter address");
                }
                else if (phone.getText().toString().equals(""))
                {
                    phone.setError("enter phone");
                }
                else if (password.getText().toString().equals(""))
                {
                    password.setError("enter password");
                }
              else   if(password.getText().toString().length()<5 &&!isValidPassword(password.getText().toString())){
                    password.setError("enter valid password");
                }
                else if (conpass.getText().toString().equals(""))
                {
                    conpass.setError("enter confirm password equals password");
                }
               else if(!password.getText().toString().equals(conpass.getText().toString())){
                    conpass.setError(" confirm password doesnot equals password");

                }
                else {
                    String tname = name.getText().toString();
                    String tadd = address.getText().toString();
                    String tpho = phone.getText().toString();
                    String tpass = password.getText().toString();
                    insertData(tname, tadd, tpho, tpass);
                    Toast.makeText(getApplicationContext(), "Registeration success", Toast.LENGTH_LONG).show();
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }
    public void insertData(String name,String address,String phone,String password) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,name);
        contentValues.put(DatabaseHelper.COL_3,address);
        contentValues.put(DatabaseHelper.COL_4,phone);
        contentValues.put(DatabaseHelper.COL_5,password);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null ,contentValues);
        /*if(result == -1)
            return false;
        else
            return true;*/

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
        int id=item.getItemId();
        if(id==R.id.signup)
        {
            return true;
        }
        if (id==R.id.Login)
        {
            Intent i=new Intent(signup.this,Login.class);
            startActivity(i);
        }
        if (id==R.id.home)
        {
            Intent i=new Intent(signup.this,MainActivity.class);
            startActivity(i);
        }
       /* switch(item.getItemId()){
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
        return super.onOptionsItemSelected(item);
    }
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

}
