package com.example.adminstator.bookfolodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class DownloadActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("Download");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageButton = (ImageButton) findViewById(R.id.btnbook3);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(DownloadActivity.this,Book2Activity.class);
                startActivity(myintent);
            }
        });

    }
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
        if (id == R.id.home){
            Intent myintent = new Intent(DownloadActivity.this,MainActivity.class);
            startActivity(myintent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login){
            Intent myintent = new Intent(DownloadActivity.this,LoginActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(DownloadActivity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(DownloadActivity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(DownloadActivity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(DownloadActivity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(DownloadActivity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(DownloadActivity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(DownloadActivity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report){
            Intent myintent = new Intent(DownloadActivity.this,ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    }
}
