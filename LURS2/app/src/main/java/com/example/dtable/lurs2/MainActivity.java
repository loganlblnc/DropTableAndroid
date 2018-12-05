package com.example.dtable.lurs2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.arch.persistence.room.RoomDatabase;


public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    ReviewDao dbDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomnav = findViewById((R.id.bottom_navigation));
        bottomnav.setOnNavigationItemSelectedListener(navListener);


        db=AppDatabase.getFileDatabase(getBaseContext());
        dbDao=db.getReviewDao();
        Handler dbHandler=new Handler(dbDao);
        dbHandler.delete();
        dbHandler.createDB();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_create:
                            selectedFragment = new CreateFragment();
                            break;
                        case R.id.nav_rate:
                            selectedFragment = new RateFragment();
                            break;
                        case R.id.nav_nearby:
                            selectedFragment = new NearbyFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
