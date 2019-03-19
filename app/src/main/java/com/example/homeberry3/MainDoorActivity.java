package com.example.homeberry3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.homeberry3.DOORS.FragmentDoor;

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
                            finish();
                            break;

                        case R.id.porte1:
                            Intent intent1 = new Intent( MainDoorActivity.this, MainLampActivity.class );
                            startActivity( intent1 );
                            finish();
                            break;
                        case R.id.porte2:
                            Intent intent2 = new Intent( MainDoorActivity.this, MainWindowActivity.class );
                            startActivity( intent2 );
                            finish();
                            break;
                        case R.id.porte3:
                            Intent intent3 = new Intent( MainDoorActivity.this, MainFanActivity.class );
                            startActivity( intent3 );
                            finish();
                            break;
                    }
                    return false;
                }
            };

    public void ToDoor(View view) {
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                new FragmentDoor()).commit();
    }

}
