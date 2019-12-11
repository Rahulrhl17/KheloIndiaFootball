package com.viaedge.kheloindiafootball.Activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.viaedge.kheloindiafootball.Adapters.HomePager;
import com.viaedge.kheloindiafootball.R;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    RelativeLayout playerInfo;
    TextView profile,explore,fixtures,team,stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        tabLayout = findViewById(R.id.tabLayout);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        viewPager =  findViewById(R.id.viewpager);
        profile = findViewById(R.id.profile);
        explore = findViewById(R.id.explore);
        fixtures = findViewById(R.id.fixtures);
        stats = findViewById(R.id.stats);
        team = findViewById(R.id.team);
        HomePager adapter = new HomePager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);
        LinearLayout logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        });
        profile.setOnClickListener( v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
        explore.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,DefaultActivity.class);
            intent.putExtra("fragment","explore");
            startActivity(intent);
        });
        fixtures.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,DefaultActivity.class);
            intent.putExtra("fragment","fixtures");
            startActivity(intent);
        });
        team.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,DefaultActivity.class);
            intent.putExtra("fragment","team");
            startActivity(intent);
        });
        stats.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,DefaultActivity.class);
            intent.putExtra("fragment","match");
            startActivity(intent);
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
