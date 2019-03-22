package com.example.homeberry3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class MainWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_window );

        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {

                        case R.id.luci:
                            Intent intent = new Intent( MainWindowActivity.this, MainWindowActivity.class );
                            startActivity( intent );
                            finish();
                            break;
                        case R.id.luci1:
                            Intent intent1 = new Intent( MainWindowActivity.this, MainLampActivity.class );
                            startActivity( intent1 );
                            finish();
                            break;
                        case R.id.luci2:
                            Intent intent2 = new Intent( MainWindowActivity.this, MainDoorActivity.class );
                            startActivity( intent2 );
                            finish();
                            break;
                        case R.id.luci3:
                            Intent intent3 = new Intent( MainWindowActivity.this, MainFanActivity.class );
                            startActivity( intent3 );
                            finish();
                            break;
                    }

                    return false;
                }
            };

    public void ToWindow1(View view) {
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                new FragmentWindow()).commit();
    }
}
