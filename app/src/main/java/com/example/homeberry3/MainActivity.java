package com.example.homeberry3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void ToLamp(View view) {
        startActivity( new Intent( MainActivity.this, MainLampActivity.class ) );
    }

    public void ToDoor(View view) {
        startActivity( new Intent( MainActivity.this, MainDoorActivity.class ) );
    }

    public void ToWindow(View view) {
        startActivity( new Intent( MainActivity.this, MainWindowActivity.class ) );
    }

    public void ToFan(View view) {
        startActivity( new Intent( MainActivity.this, MainFanActivity.class ) );
    }
}
