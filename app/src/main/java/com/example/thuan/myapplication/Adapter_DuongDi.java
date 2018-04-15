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

public class Adapter_DuongDi extends ArrayAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> danhsachDuongDi;

    public Adapter_DuongDi(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.danhsachDuongDi=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView txtDuongDi;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,parent, false);

        txtDuongDi=(TextView)convertView.findViewById(R.id.txtDuongDi);


        txtDuongDi.setText(danhsachDuongDi.get(position).toString());

        return convertView;
    }
}
