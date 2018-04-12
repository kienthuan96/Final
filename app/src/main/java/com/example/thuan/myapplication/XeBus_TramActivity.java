package com.example.thuan.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class XeBus_TramActivity extends AppCompatActivity {
    final String DATABASE_NAME = "csdl.sqlite";
    private ArrayList<Bus_Station> listBusStation;
    private ArrayList<Bus> listBus;
    private ArrayList<Station> listStation;
    SQLiteDatabase sqLiteDatabase;
    TextView txtHienThi;
    Integer busID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xe_bus__tram);
        id();

        listBusStation=new ArrayList<>();
        listBus=new ArrayList<>();
        listStation=new ArrayList<>();
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("goi");
        busID=bundle.getInt("idbus");
        readData();
        readData1();
        readStation();
//        tim(busID);
    }
    private void id(){
        txtHienThi=findViewById(R.id.txtHienThi);
    }
    private void readStation(){
        String kq="";
        Integer so=0;
        for(int i=0; i<listBusStation.size(); i++){
            if(busID == listBusStation.get(i).getBus_id()){
                so=listBusStation.get(i).getStation_id();
                kq+=so;
                for(int j=0; j<listStation.size(); j++){
                    if(so == listStation.get(j).getStation_id())
                    kq+=listStation.get(j).getName();
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
    private void readData1(){
        sqLiteDatabase = DBBangGiaXe.initDatabase(this, DATABASE_NAME);
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

    private void tim(Integer id){
        sqLiteDatabase = DBBangGiaXe.initDatabase(this, DATABASE_NAME);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM station WHERE id="+id, null);
        String ten=cursor.getString(1);
        txtHienThi.setText(ten);
    }
}
