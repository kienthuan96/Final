package com.example.thuan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ViewFlipper;

public class btnTraCuuTuyenXe extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracuutuyenxe);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewAnh1);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

       // Boolean isAutoStart = viewFlipper.isAutoStart();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Xử lý thanh công cụ mục nhấp vào đây. Thanh tác vụ sẽ
        // tự động xử lý các nhấp chuột vào nút Home / Up, do đó, dài
        // khi bạn chỉ định hoạt động của cha mẹ trong AndroidManifest.xml.
        int id = item.getItemId();

        //không kiểm tra
        if (id == R.id.always) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
