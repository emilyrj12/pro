package com.example.tm;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class updateitem extends AppCompatActivity {
   /* ImageView imageView;
    Button b1,b2,b3,b4;
    private static final int PICK_IMAGE=100;
    Uri imageUri;
    TextView t1;
    EditText t2;
    DatabaseHelper sqliteHelper;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;*/
   ImageView imageView;
    Button b1,b2,b3,b4;
    private static final int PICK_IMAGE=100;
    Uri imageUri;
    TextView t1;
    EditText t2;
    DatabaseHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateitem);
       // sqliteHelper=new DatabaseHelper(this);

        /*imageView=(ImageView)findViewById(R.id.imageView);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.update);
        b3=(Button)findViewById(R.id.cancel);
        b4=(Button)findViewById(R.id.delete);
        t1=(TextView)findViewById(R.id.textView) ;
        t2=(EditText)findViewById(R.id.ed2);
        Intent p=getIntent();
        int[]id=p.getIntArrayExtra("id");
        int pos=p.getIntExtra("pos",0);
        t1.setText(p.getStringExtra("item"));
        final int val=id[pos];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallary();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=t2.getText().toString();
                String item=t1.getText().toString();
                if(price.isEmpty()){
                    Snackbar.make(b2, "field is empty ", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    sqliteHelper.updatePlace(val,price);

                    Snackbar.make(b2, "price updated successfully! ", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(updateitem.this,Admin_home.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqliteHelper.deleteItem(val);
                Snackbar.make(b2, "Item deleted successfully! ", Snackbar.LENGTH_LONG).show();
                Intent i=new Intent(updateitem.this,Admin_home.class);
                startActivity(i);
                finish();
            }
        });

    }
    private void openGallary(){
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            imageView.setImageURI(imageUri);
        }
        /*sqliteHelper=new DatabaseHelper(this);
        db=sqliteHelper.getReadableDatabase();
        imageView=(ImageView)findViewById(R.id.imageView);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.update);
        b3=(Button)findViewById(R.id.cancel);
        b4=(Button)findViewById(R.id.delete);
        t1=(TextView)findViewById(R.id.textView) ;
        t2=(EditText)findViewById(R.id.ed2);
        Intent p=getIntent();
        int[]id=p.getIntArrayExtra("id");
        int pos=p.getIntExtra("pos",0);
        //String item=p.getStringExtra("item");
        t1.setText(p.getStringExtra("item"));
       // Toast.makeText(getApplicationContext(),item , Toast.LENGTH_LONG).show();
       final int val=id[pos];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallary();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=t2.getText().toString();
                String item=t1.getText().toString();
                if(price.isEmpty()){
                    Snackbar.make(b2, "field is empty ", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                   sqliteHelper.updatePrice(val,price);

                    Snackbar.make(b2, "details updated successfully! ", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(updateitem.this,Admin_home.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqliteHelper.deleteItem(val);
                Snackbar.make(b2, "Item deleted successfully! ", Snackbar.LENGTH_LONG).show();
                Intent i=new Intent(updateitem.this,Admin_home.class);
                startActivity(i);
                finish();
            }
        });

    }
    private void openGallary(){
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            imageView.setImageURI(imageUri);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
