package com.example.thuan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.ViewFlipper;

public class btnBangGiaVe_Activity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banggiavexe);
        viewFlipper =(ViewFlipper)findViewById(R.id.viewAnh);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        //Cài đặt Tab Host để sử dụng
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("PHỔ THÔNG");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PHỔ THÔNG ");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("ĐƯỜNG DÀI" );
        spec.setContent(R.id.tab2);

        spec.setIndicator("ĐƯỜNG DÀI ");
        host.addTab(spec);
        //Tab 3
        spec = host.newTabSpec("LƯU Ý");
        spec.setContent(R.id.tab3);
        spec.setIndicator("LƯU Ý");
        host.addTab(spec);
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
