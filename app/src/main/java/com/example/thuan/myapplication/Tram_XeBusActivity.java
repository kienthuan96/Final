package com.example.thuan.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Tram_XeBusActivity extends AppCompatActivity {
    final String DATABASE_NAME = "csdl.sqlite";
    private ArrayList<Bus_Station> listBusStation;
    private ArrayList<Bus> listBus;
    SQLiteDatabase sqLiteDatabase;
    TextView txtHienThi;
    Integer stationID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tram__xe_bus);
        id();
        listBusStation=new ArrayList<>();
        listBus=new ArrayList<>();

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("goi1");
        stationID=bundle.getInt("idstation");

        readData();
        readData1();
        readBus();
    }

    private void id(){
        txtHienThi=findViewById(R.id.txtHienThi1);
    }
    private void readBus(){
        String kq="";
        Integer so=0;
        for(int i=0; i<listBusStation.size(); i++){
            if(stationID == listBusStation.get(i).getStation_id()){
                so=listBusStation.get(i).getBus_id();
                kq+=so;
                for(int j=0; j<listBus.size(); j++){
                    if(so == listBus.get(j).getBus_id())
                        kq+=listBus.get(j).getTenXe();
                }
            }
        }

        txtHienThi.setText(kq);
    }

    private void readData() {
        sqLiteDatabase = DBBangGiaXe.initDatabase(this, DATABASE_NAME);
        listBusStation.clear();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM bus_station", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            Integer bus_id = cursor.getInt(0);
            Integer station_id = cursor.getInt(1);
            Bus_Station busStation = new Bus_Station(bus_id, station_id);
            listBusStation.add(busStation);
        }
    }

    private void readData1() {
        sqLiteDatabase = DBBangGiaXe.initDatabase(this, DATABASE_NAME);
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
