package com.example.bottom_nav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    final String TAG = MainActivity.this.getPackageName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        registerActions();
        loadFragment(HomeFragment.newInstance("", ""));
    }
//getSupportFragmentManager().beginTransaction().replace(R.id.linearLayoutForPranRFLFragment, fragmentAccountNumberInput).commit();
    private void registerActions() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        loadFragment(HomeFragment.newInstance("", ""));
                        break;
                    case R.id.Search:
                        loadFragment(TestFragment.newInstance("", ""));
                        break;
                    case R.id.Profile:
                        loadFragment(NewFragment.newInstance("", ""));
                        break;

                }


                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.linLayoutContainer, fragment).commit();
    }

    private void initializeUI() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
    }
}