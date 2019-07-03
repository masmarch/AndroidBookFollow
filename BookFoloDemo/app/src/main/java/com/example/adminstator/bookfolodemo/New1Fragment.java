package com.example.adminstator.bookfolodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class New1Fragment extends Fragment {
    ImageButton imageButton;
    ImageButton imageButton1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new1, container, false);
        imageButton = (ImageButton)view.findViewById(R.id.btnbook2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getActivity(),Buy1Activity.class);
                startActivity(myintent);
            }
        });
        imageButton1 = (ImageButton)view.findViewById(R.id.btnbook3);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getActivity(),Buy2Activity.class);
                startActivity(myintent);
            }
        });
        return view;
    }

}
