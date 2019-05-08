package com.example.tm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Admin_home extends AppCompatActivity {
    Button button,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Admin_home.this);
                alertDialogBuilder.setMessage("Make your decision");
                alertDialogBuilder.setPositiveButton("View User", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Admin_home.this,view.class);
                        startActivity(i);
                    }
                });
               /* alertDialogBuilder.setNegativeButton("Approve User", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Admin_home.this,Approveuser.class);
                        startActivity(i);
                    }
                });*/
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Admin_home.this);
                alertDialogBuilder.setMessage("Make your decision");
                alertDialogBuilder.setPositiveButton("Add Places at Corresponding district", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Admin_home.this,add.class);
                        startActivity(i);
                    }
                });
                /*alertDialogBuilder.setNegativeButton("Update Item", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(Admin_home.this,updateitem.class);
                        startActivity(i);
                    }
                });*/
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

}
