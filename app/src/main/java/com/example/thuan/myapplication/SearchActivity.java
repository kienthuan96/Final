package com.example.thuan.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    final String DATABASE_NAME = "mydatabase.sqlite";
    SQLiteDatabase database;
    ListView listViewBus;
    AutoCompleteTextView source, destination;

    Button btnClick;
    ArrayAdapter<String> adapterAutoComplete;
    ArrayList<String> location = new ArrayList<String>();
    ArrayList<SearchBus> listSearchBus;
    Adapter_SearchBus adapter_searchBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        readDataStation();

        setAdapterAutoComplete();

        addControls();
    }

    private void addControls() {
        btnClick = (Button) findViewById(R.id.btnSearch);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDataBus();
            }
        });

        listViewBus = (ListView) findViewById(R.id.listViewBus);
        listSearchBus = new ArrayList<>();
        adapter_searchBus = new Adapter_SearchBus(this, listSearchBus);
        listViewBus.setAdapter(adapter_searchBus);
    }

    private void readDataStation(){
        database = DBBangGiaXe.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM station",null);
        location.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            String name = cursor.getString(1);
            location.add(name);
        }
    }

    private void readDataBus(){
        String src = source.getText().toString();
        String des = destination.getText().toString();

        if(src.equals("") || des.equals("")) {
            Toast.makeText(this, "Nhập đẩy đủ dữ liệu để tìm kiếm",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Cursor cursor = database.rawQuery("select * from bus where id IN (select bus_id from bus_station where station_id IN (select id from station where station.name in ('"+ src +"','" + des + "')) group by bus_id having count(bus_id) = 2)",null);
        listSearchBus.clear();

        if(cursor.getCount() > 0) {
            for(int i = 0; i < cursor.getCount(); i++){
                cursor.moveToPosition(i);
                Integer number = cursor.getInt(1);
                String name = cursor.getString(2);
                listSearchBus.add(new SearchBus(number, name));
            }
            adapter_searchBus.notifyDataSetChanged();
        }
        else {
            Toast.makeText(this, "Không tìm thấy xe bus nào đi qua 2 địa điểm này",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void setAdapterAutoComplete() {
        source = (AutoCompleteTextView) findViewById(R.id.autoCompleteSource);
        destination = (AutoCompleteTextView) findViewById(R.id.autoCompleteDestination);
        adapterAutoComplete = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, location);
        source.setAdapter(adapterAutoComplete);
        destination.setAdapter(adapterAutoComplete);
    }
}
