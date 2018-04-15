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

public class Adapter_XeBus extends ArrayAdapter {
    private Context context;
    private int layout;
    private ArrayList<Bus> danhsachBus;

    public Adapter_XeBus(@NonNull Context context, int resource, @NonNull ArrayList<Bus> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.danhsachBus=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView txtMaBus,txtTenBus;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,parent, false);

        txtMaBus=(TextView)convertView.findViewById(R.id.txtSoXe);
        txtTenBus=(TextView)convertView.findViewById(R.id.txtTenXe);

        Bus bus=danhsachBus.get(position);
        txtMaBus.setText(bus.getMaXe().toString());
        txtTenBus.setText(bus.getTenXe().toString());

        return convertView;
    }
}


