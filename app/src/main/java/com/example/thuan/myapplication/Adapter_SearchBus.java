package com.example.thuan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_SearchBus extends BaseAdapter {
    Activity context;
    ArrayList<SearchBus> list;

    public Adapter_SearchBus(Activity context, ArrayList<SearchBus> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.layout_item_bus_search, null);

        TextView txtNumBer = (TextView) row.findViewById(R.id.txtNumber);
        TextView txtName = (TextView) row.findViewById(R.id.txtName);

        SearchBus searchBus = list.get(position);

        txtName.setText(searchBus.getName());
        txtNumBer.setText(searchBus.getNumber().toString());
        return row;
    }
}
