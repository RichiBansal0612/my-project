package com.example.gravity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    WifiManager wifiManager;
    private boolean blue = true;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);
        wifiManager=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    wifiManager.setWifiEnabled(true);
                    blue=true;
                    Toast.makeText(MainActivity.this, "Wifi On", Toast.LENGTH_SHORT).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    blue=false;
                    Toast.makeText(MainActivity.this, "Wifi off", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}