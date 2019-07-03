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
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    EditText name,pass,email,lname,bday,username;
    ImageButton wallet;
    RadioGroup sex;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        username = (EditText) findViewById(R.id.username);
        email= (EditText)findViewById(R.id.email);
        name= (EditText) findViewById(R.id.name);
        pass= (EditText) findViewById(R.id.password);
        wallet= (ImageButton) findViewById(R.id.btnwallet);
        lname= (EditText) findViewById(R.id.lname);
        bday= (EditText) findViewById(R.id.date);
        sex = (RadioGroup) findViewById(R.id.gender);

        connectionClass = new ConnectionClass();

        progressDialog=new ProgressDialog(this);

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doregister doregister = new Doregister();
                doregister.execute("");
            }
        });

    }
    public class Doregister extends AsyncTask<String,String,String>
    {
        String namestr=name.getText().toString();
        String passstr=pass.getText().toString();
        String emailstr=email.getText().toString();
        String lnamestr=lname.getText().toString();
        String bdaystr=bday.getText().toString();
        String userstr=username.getText().toString();
        String z="";
        boolean isSuccess=false;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            if(namestr.trim().equals("")||passstr.trim().equals("")||emailstr.trim().equals("")||
                    lnamestr.trim().equals("")||bdaystr.trim().equals("")|| userstr.trim().equals(""))
                z = "Please enter all fields....";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {
                        String query="insert into user values('"+userstr+"','"+passstr+"','"+namestr+"','"+lnamestr+"','"+emailstr+"','male','"+bdaystr+"','normal')";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(query);
                        z = "Please connect wallet!";
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
                String data = userstr;
                Intent pass_value = new Intent(RegisterActivity.this,ConnectActivity.class);
                pass_value.putExtra("valuepass",data);
                startActivity(pass_value);
//                startActivity(new Intent(RegisterActivity.this,ConnectActivity.class));
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.home){
            Intent myintent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(myintent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login){
            Intent myintent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.register){
            Intent myintent = new Intent(RegisterActivity.this,RegisterActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.market){
            Intent myintent = new Intent(RegisterActivity.this,MarketActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.sell){
            Intent myintent = new Intent(RegisterActivity.this,SellActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.store){
            Intent myintent = new Intent(RegisterActivity.this,MystoreActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.history){
            Intent myintent = new Intent(RegisterActivity.this,HistoryActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.download){
            Intent myintent = new Intent(RegisterActivity.this,DownloadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.upload){
            Intent myintent = new Intent(RegisterActivity.this,UploadActivity.class);
            startActivity(myintent);
        }
        if (id == R.id.report){
            Intent myintent = new Intent(RegisterActivity.this,ReportActivity.class);
            startActivity(myintent);
        }
        return false;
    }
}
