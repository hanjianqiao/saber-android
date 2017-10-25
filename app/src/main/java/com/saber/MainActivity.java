package com.saber;

import android.app.ActivityGroup;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {

    final int OVERLAY_PERMISSION_REQ_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
        tabHost.setup(this.getLocalActivityManager());

        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");

        Log.d("saber", tab1.toString());
        tab1.setContent(R.id.ll_tab1);
        tab1.setIndicator("Tab1");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        tab2.setContent(new Intent(this, Main2Activity.class));
        tab2.setIndicator("Tab2");
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Third Tab");
        tab3.setContent(R.id.ll_tab3);
        tab3.setIndicator("Tab3");
        tabHost.addTab(tab3);

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(i, OVERLAY_PERMISSION_REQ_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("saber", "resultCode: " + resultCode);
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                }
            }
        }
    }
}
