package com.example.tm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper v_flipper;
    //ImageView i1;
    int[] images = {R.drawable.kut,R.drawable.madh,R.drawable.the,R.drawable.trip,R.drawable.woo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v_flipper = findViewById(R.id.v_flipper);
        // i1=(ImageView)findViewById(R.id.i1);
        // i1.setImageResource(R.drawable.wat);
        for(int i=0;i<images.length;i++) {
            flip_image(images[i]);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
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

*/int id=item.getItemId();
if(id==R.id.home)
{
    return true;
}
if (id==R.id.Login)
{
    Intent i=new Intent(MainActivity.this,Login.class);
    startActivity(i);
}
        if (id==R.id.signup)
        {
            Intent i=new Intent(MainActivity.this,signup.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    public void flip_image(int i)
    {
        ImageView view=new ImageView(this);
        view.setBackgroundResource(i);
        v_flipper.addView(view);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
