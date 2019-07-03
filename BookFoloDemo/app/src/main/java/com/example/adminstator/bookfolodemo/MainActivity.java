package com.example.adminstator.bookfolodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    public void ChangeFragment(View view){
        Fragment fragment;
        if(view.getId() == R.id.btnnew) {
            NewFragment newfragment = new NewFragment();
            fragment = newfragment;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        if(view.getId() == R.id.btncommend){
            CommendFragment commendfragment = new CommendFragment();
            fragment = commendfragment;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
        }
        if(view.getId() == R.id.btntop) {
            TopFragment topfragment = new TopFragment();
            fragment = topfragment;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }// image fragment button

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.navigation_alert,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent myintent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(myintent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login){
           Intent myintent = new Intent(MainActivity.this,LoginActivity.class);
           startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(MainActivity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(MainActivity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(MainActivity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(MainActivity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(MainActivity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(MainActivity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report) {
            Intent myintent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    } // menu list wiew navigation
}
