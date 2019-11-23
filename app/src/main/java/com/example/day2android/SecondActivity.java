package com.example.day2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

     TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv=findViewById(R.id.txtNameShow);
        Bundle mBundle=getIntent().getExtras();
        if(mBundle!=null)
        {
            String name=mBundle.getString("name");
            Log.d("Name",name);
            tv.setText(name);
        }
    }
}
