package com.example.thuan.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   //     setContentView(R.layout.activity_tracuutuyenxe);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_xebus:
                Intent intent=new Intent(MainActivity.this, XeBusActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_tram:
                Intent intent2=new Intent(MainActivity.this, TramActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_giave:
                Intent intent1=new Intent(MainActivity.this, BangGiaVeActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_timkiem:
                Intent intentSearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intentSearch);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
