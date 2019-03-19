package com.example.homeberry3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

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
                            break;
                        case R.id.luci1:
                            Intent intent1 = new Intent( MainLampActivity.this, MainDoorActivity.class );
                            startActivity( intent1 );
                            break;
                        case R.id.luci2:
                            Intent intent2 = new Intent( MainLampActivity.this, MainWindowActivity.class );
                            startActivity( intent2 );
                            break;
                        case R.id.luci3:
                            Intent intent3 = new Intent( MainLampActivity.this, MainFanActivity.class );
                            startActivity( intent3 );
                            break;

                    }

/*                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.luci:
                            selectedFragment = new FragmentLight();
                            break;
                        case R.id.luci1:
                            selectedFragment = new FragmentLight1();
                            break;
                        case R.id.luci2:
                            selectedFragment = new FragmentLight2();
                            break;
                        case R.id.luci3:
                            selectedFragment = new FragmentLight3();
                            break;
                        case R.id.luci4:
                            selectedFragment = new FragmentLight4();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit(); */
                    return false;
                };
            };

                public void ToLamp1(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight1() ).commit();
                }

                public void ToLamp2(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight2() ).commit();
                }

                public void ToLamp3(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight3() ).commit();
                }

                public void ToLamp4(View view) {
                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                            new FragmentLight4() ).commit();
                }
}
