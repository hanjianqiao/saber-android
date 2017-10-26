package com.saber;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import static android.R.attr.host;

public class MainActivity extends AppCompatActivity {

    final int OVERLAY_PERMISSION_REQ_CODE = 0;

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        tabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Sefirot");
        //tab1.setContent(R.id.ll_tab1);
        tab1.setIndicator("Sefirot");
        tabHost.addTab(tab1, Sefirot.class, null);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Jarvis");
        tab2.setIndicator("Jarvis");
        //tab2.setContent(R.id.ll_tab2);
        tabHost.addTab(tab2, Jarvis.class, null);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Magus");
        //tab3.setContent(R.id.ll_tab3);
        tab3.setIndicator("Magus");
        tabHost.addTab(tab3, Magus.class, null);



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
