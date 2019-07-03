package com.example.adminstator.bookfolodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ThankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank);
        getSupportActionBar().setTitle("Thank You");
        ImageButton imagehm = (ImageButton) findViewById(R.id.btnhm);
        imagehm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(ThankActivity.this,MainActivity.class);
                startActivity(myintent);
            }
        });
    }
}
