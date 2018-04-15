package com.example.thuan.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class XeBusActivity extends AppCompatActivity {

    ListView lstXeBus;

    final String DATABASE_NAME = "csdl.sqlite";
    SQLiteDatabase sqLiteDatabase;
    ArrayList<Bus> listBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xe_bus);

        id();
        listBus = new ArrayList<Bus>();
        readData();
        Adapter_XeBus adapter_xeBus=new Adapter_XeBus(XeBusActivity.this,R.layout.layout_item_xebus,listBus);
        lstXeBus.setAdapter(adapter_xeBus);

        lstXeBus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer idBus=listBus.get(i).getBus_id();
                Intent intent=new Intent(XeBusActivity.this,XeBus_TramActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("idbus",idBus);
                intent.putExtra("goi",bundle);
                startActivity(intent);
            }
        });
    }

    private void id() {
        lstXeBus = findViewById(R.id.lstXeBus);
    }

    private void readData() {
        sqLiteDatabase = DB.initDatabase(this, DATABASE_NAME);
        listBus.clear();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM bus", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            Integer id=cursor.getInt(0);
            Integer maXe = cursor.getInt(1);
            String tenXe = cursor.getString(2);
            Bus bus = new Bus(maXe,id, tenXe);
            listBus.add(bus);
        }
    }
}
