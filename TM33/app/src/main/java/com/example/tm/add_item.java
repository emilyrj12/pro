package com.example.tm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;

public class add_item extends AppCompatActivity {
    Button b1,b2,b3;
    ImageView imageView;
    Spinner spinner;
    EditText t1,t2;
    String picturePath;
    String place,descr,dist,img,places[];
    int pos;
    //DatabaseHelper sqliteHelper;
    SQLiteDatabase db;
    private static int RESULT_LOAD_IMAGE = 1;
    CustomAdapter cm=null;
    Uri imageUri;
    final int REQUEST_CODE_GALLERY = 999;

    public static DatabaseHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
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
        b1 = (Button)findViewById(R.id.button) ;
        b2=(Button)findViewById(R.id.button5);
        b3=(Button)findViewById(R.id.button4);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        spinner=(Spinner)findViewById(R.id.spinner);
imageView=(ImageView)findViewById(R.id.imageView);
        sqLiteHelper=new DatabaseHelper(this);
        db=sqLiteHelper.getReadableDatabase();
        Cursor cursor=db.query(DatabaseHelper.TABLE_DIST,
                new String[]{DatabaseHelper.KEY_DIST_ID, DatabaseHelper.KEY_DISTRICT},//Selecting columns want to query
                null,
                null,//Where clause
                null, null, null);
        places=new String[cursor.getCount()];
        int i=0;
        do{
            cursor.moveToNext();
            places[i]=cursor.getString(1);
            i=i+1;
        }while (i<cursor.getCount());

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places);

//// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        add_item.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    place=t1.getText().toString().trim();
                    pos=spinner.getSelectedItemPosition();
//                Toast.makeText(Admin_Add_item.this, pos, Toast.LENGTH_SHORT).show();
                    dist=spinner.getItemAtPosition(pos).toString();
                    descr=t2.getText().toString().trim();
                             byte[] im = imageViewToByte(imageView);
                    sqLiteHelper.insertData(dist
                            ,place
                            ,descr,
                            im
                    );
                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                    t1.setText("");
                    t2.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_item.this, placelist.class);
                startActivity(intent);
               // finish();
                /////////////////////////
            }
        });
        /*b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place=t1.getText().toString();
                pos=spinner.getSelectedItemPosition();
//                Toast.makeText(Admin_Add_item.this, pos, Toast.LENGTH_SHORT).show();
                dist=spinner.getItemAtPosition(pos).toString();
                descr=t2.getText().toString();
                if((place.isEmpty())||descr.isEmpty())
                {
                    Snackbar.make(b1, "field is empty ", Snackbar.LENGTH_LONG).show();
                }
                else
                {

                    sqliteHelper.addplace(dist,place,descr);
                    Snackbar.make(b1, "Places Added successfully! ", Snackbar.LENGTH_LONG).show();
                }
            }
        });*/

       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGallary();

            }
        });*/
      /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        add_item.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(add_item.this,Admin_home.class);
                startActivity(i);
                finish();
                /////////////////////////
            }
        });
    }
    private void openGallary(){

        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageURI(selectedImage);
            imageView.setMaxHeight(400);
            imageView.setMaxWidth(550);


        }
        else{
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }*/
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
