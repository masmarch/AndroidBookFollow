package com.example.adminstator.bookfolodemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Buy2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageButton imagedialog;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy2);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("Live or not รักปาฏิหาริย์ย้อนวัย");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        imagedialog = (ImageButton)findViewById(R.id.btnbuy);
        imagedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuider = new AlertDialog.Builder(Buy2Activity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_pin,null);
                final EditText ePin = (EditText) mView.findViewById(R.id.ePin);
                ImageButton imageButton = (ImageButton) mView.findViewById(R.id.btnconfirm);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!ePin.getText().toString().isEmpty()){
                            Intent myintent = new Intent(Buy2Activity.this,MarketActivity.class);
                            startActivity(myintent);
                        }
                        else{
                            Toast.makeText(Buy2Activity.this,"Fail!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                mBuider.setView(mView);
                AlertDialog dialog = mBuider.create();
                dialog.show();
            }
        });
        ImageButton imagereport = (ImageButton) findViewById(R.id.btnre);
        imagereport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Buy2Activity.this,ReportActivity.class);
                startActivity(myintent);
            }
        });
        ImageButton imagereport1 = (ImageButton) findViewById(R.id.btnre1);
        imagereport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Buy2Activity.this,ReportActivity.class);
                startActivity(myintent);
            }
        });
        ImageButton imagereport2 = (ImageButton) findViewById(R.id.btnre2);
        imagereport2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Buy2Activity.this,ReportActivity.class);
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
            Intent myintent = new Intent(Buy2Activity.this,LoginActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(Buy2Activity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(Buy2Activity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(Buy2Activity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(Buy2Activity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(Buy2Activity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(Buy2Activity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(Buy2Activity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report){
            Intent myintent = new Intent(Buy2Activity.this,ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    }
}
