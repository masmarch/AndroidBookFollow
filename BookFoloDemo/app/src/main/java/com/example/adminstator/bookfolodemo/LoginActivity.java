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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    EditText name,pass;
    ImageButton login;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("Log in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        name= (EditText) findViewById(R.id.btnuser);
        pass= (EditText) findViewById(R.id.btnpass);
        login= (ImageButton) findViewById(R.id.btnlogin);

        connectionClass = new ConnectionClass();

        progressDialog=new ProgressDialog(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dologin dologin=new Dologin();
                dologin.execute();
            }
        });

    }
    private class Dologin extends AsyncTask<String,String,String>{

        String namestr=name.getText().toString();
        String passstr=pass.getText().toString();
        String z="";
        boolean isSuccess=false;
        String nm,password;

        @Override
        protected void onPreExecute() {

            progressDialog.setMessage("Loading...");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            if(namestr.trim().equals("")||passstr.trim().equals(""))
                z = "Please enter all fields....";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {

                        String query=" select * from user where username='"+namestr+"' and password = '"+passstr+"'and status !='block'";


                        Statement stmt = con.createStatement();
                        // stmt.executeUpdate(query);

                        ResultSet rs=stmt.executeQuery(query);

                        while (rs.next())

                        {
                            nm= rs.getString(2);
                            password=rs.getString(3);

                            if(nm.equals(namestr)&&password.equals(passstr))
                            {
                                isSuccess=true;
                                z = "Login successfull";
                            }
                            else
                                isSuccess=false;
                        }
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

                Intent intent=new Intent(LoginActivity.this,MainActivity.class);

                intent.putExtra("name",namestr);

                startActivity(intent);
            }
            progressDialog.hide();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.navigation_alert,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.home){
            Intent myintent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(myintent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login){
            Intent myintent = new Intent(LoginActivity.this,LoginActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(LoginActivity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(LoginActivity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(LoginActivity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(LoginActivity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(LoginActivity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(LoginActivity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report){
            Intent myintent = new Intent(LoginActivity.this,ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    }
}
