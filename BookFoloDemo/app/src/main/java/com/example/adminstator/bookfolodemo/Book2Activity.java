package com.example.adminstator.bookfolodemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Book2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("เมื่อผมกลายเป็นสาวมอปลาย");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageButton = (ImageButton) findViewById(R.id.btnschool1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Book2Activity.this,Read2Activity.class);
                startActivity(myintent);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login){
            Intent myintent = new Intent(Book2Activity.this,LoginActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(Book2Activity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(Book2Activity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(Book2Activity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(Book2Activity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(Book2Activity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(Book2Activity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(Book2Activity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report){
            Intent myintent = new Intent(Book2Activity.this,ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    }
}
