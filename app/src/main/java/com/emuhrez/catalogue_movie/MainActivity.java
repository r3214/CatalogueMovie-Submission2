package com.emuhrez.catalogue_movie;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movie:
                    Fragment fragmentMovie = new MoviesFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragmentMovie, fragmentMovie.getClass().getSimpleName())
                            .commit();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.dashboard_movie));
                    }
                    return true;
                case R.id.navigation_tvseries:
                    Fragment fragmentTvSeries = new TvFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragmentTvSeries, fragmentTvSeries.getClass().getSimpleName())
                            .commit();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.dashboard_tvseries));
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null){
            navigation.setSelectedItemId(R.id.navigation_movie);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
