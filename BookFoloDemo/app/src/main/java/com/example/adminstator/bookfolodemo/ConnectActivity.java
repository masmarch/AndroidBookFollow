package com.example.adminstator.bookfolodemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Statement;

public class ConnectActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    EditText name,pin,exp,cvv,cnum,repin;
    ImageButton done;
    RadioGroup sex;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("ConnectWallet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        cnum = (EditText) findViewById(R.id.txtcard);
        exp= (EditText)findViewById(R.id.txtexp);
        cvv= (EditText) findViewById(R.id.txtccv);
        name= (EditText) findViewById(R.id.txtname);
        done = (ImageButton) findViewById(R.id.btndone);
        repin= (EditText) findViewById(R.id.txtrepin);
        pin= (EditText) findViewById(R.id.txtpin);


        connectionClass = new ConnectionClass();

        progressDialog=new ProgressDialog(this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doregister doregister = new Doregister();
                doregister.execute("");
            }
        });

    }
    public class Doregister extends AsyncTask<String,String,String>
    {
        String cnumstr=cnum.getText().toString();
        String expstr=exp.getText().toString();
        String cvvstr=cvv.getText().toString();
        String namestr=name.getText().toString();
        String pinstr=pin.getText().toString();
        String repinstr=repin.getText().toString();
        String z="";
        boolean isSuccess=false;
        String data1 = getIntent().getStringExtra("valuepass");

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            if(namestr.trim().equals("")||pinstr.trim().equals("")||repinstr.trim().equals("")||
                    cnumstr.trim().equals("")||expstr.trim().equals("")|| cvvstr.trim().equals(""))
                z = "Please enter all fields....";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {
                        String query="insert into wallet values('"+cnumstr+"','ktb','"+expstr+"','"+cvvstr+"','"+namestr+"','"+pinstr+"','"+data1+"')";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(query);
                        z = "Please Login user!";
                        isSuccess=true;
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "Exceptions"+ex;
                }
            }
            return z;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getBaseContext(),""+z,Toast.LENGTH_LONG).show();

            if(isSuccess) {
                startActivity(new Intent(ConnectActivity.this,LoginActivity.class));
            }
            progressDialog.hide();
        }
    }
    @Override
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
            Intent myintent = new Intent(ConnectActivity.this,LoginActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(ConnectActivity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(ConnectActivity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(ConnectActivity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(ConnectActivity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(ConnectActivity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(ConnectActivity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(ConnectActivity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report){
            Intent myintent = new Intent(ConnectActivity.this,ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    }
}
