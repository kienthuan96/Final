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

public class TramActivity extends AppCompatActivity {
    final String DATABASE_NAME = "csdl.sqlite";

    SQLiteDatabase sqLiteDatabase;
    ArrayList<Station> listStation;
    ListView lstTram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tram);
        id();

        listStation=new ArrayList<>();
        readData();
        Adapter_Tram adapter_tram =new Adapter_Tram(TramActivity.this, R.layout.layout_item_tram,listStation);
        lstTram.setAdapter(adapter_tram);
        lstTram.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer idStation=listStation.get(i).getStation_id();
                Intent intent=new Intent(TramActivity.this,Tram_XeBusActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("idstation",idStation);
                intent.putExtra("goi1",bundle);
                startActivity(intent);
            }
        });

    }
    private void id(){
        lstTram=findViewById(R.id.lstTram);
    }
    private void readData() {
        sqLiteDatabase = DB.initDatabase(this, DATABASE_NAME);
        listStation.clear();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM station", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            Integer id=cursor.getInt(0);
            String tenTram = cursor.getString(1);
            Station station = new Station(id,tenTram);
            listStation.add(station);
        }
    }
}
