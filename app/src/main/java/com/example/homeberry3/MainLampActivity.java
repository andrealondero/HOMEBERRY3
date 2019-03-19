package com.example.homeberry3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.homeberry3.LIGHTS.FragmentLight;
import com.example.homeberry3.LIGHTS.FragmentLight1;
import com.example.homeberry3.LIGHTS.FragmentLight2;
import com.example.homeberry3.LIGHTS.FragmentLight3;

public class MainLampActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_lamp );
        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new FragmentLight()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {

                        case R.id.luci:
                            Intent intent = new Intent( MainLampActivity.this, MainLampActivity.class );
                            startActivity( intent );
                            finish();
                            break;
                        case R.id.luci1:
                            Intent intent1 = new Intent( MainLampActivity.this, MainDoorActivity.class );
                            startActivity( intent1 );
                            finish();
                            break;
                        case R.id.luci2:
                            Intent intent2 = new Intent( MainLampActivity.this, MainWindowActivity.class );
                            startActivity( intent2 );
                            finish();
                            break;
                        case R.id.luci3:
                            Intent intent3 = new Intent( MainLampActivity.this, MainFanActivity.class );
                            startActivity( intent3 );
                            finish();
                            break;

                    }

                    return false;
                };
            };

                public void ToLamp1(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight() ).commit();
                }

                public void ToLamp2(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight1() ).commit();
                }

                public void ToLamp3(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight2() ).commit();
                }

                public void ToLamp4(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight3() ).commit();
                }
}
