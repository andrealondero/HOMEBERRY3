package com.example.homeberry3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainDoorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_door );

        BottomNavigationView bottomNav = findViewById(R.id.navigation_door);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {

                        case R.id.porte:
                            Intent intent = new Intent( MainDoorActivity.this, MainDoorActivity.class );
                            startActivity( intent );
                            break;

                        case R.id.porte1:
                            Intent intent1 = new Intent( MainDoorActivity.this, MainLampActivity.class );
                            startActivity( intent1 );
                            break;
                        case R.id.porte2:
                            Intent intent2 = new Intent( MainDoorActivity.this, MainWindowActivity.class );
                            startActivity( intent2 );
                            break;
                        case R.id.porte3:
                            Intent intent3 = new Intent( MainDoorActivity.this, MainFanActivity.class );
                            startActivity( intent3 );
                            break;
                    }
                    return false;
                }
            };

    public void ToDoor1(View view) {
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                new FragmentDoor1()).commit();
    }

    public void ToDoor2(View view) {
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                new FragmentDoor2() ).commit();
    }
}
