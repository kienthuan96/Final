package com.example.thuan.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_Tram extends ArrayAdapter{
    private Context context;
    private int layout;
    private ArrayList<Station> danhsachTram;

    public Adapter_Tram(@NonNull Context context, int resource, @NonNull ArrayList<Station> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.danhsachTram=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView txtTenTram;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,parent, false);

        txtTenTram=(TextView)convertView.findViewById(R.id.txtTenTram);

        Station station=danhsachTram.get(position);
        txtTenTram.setText(station.getName().toString());

        return convertView;
    }
}
