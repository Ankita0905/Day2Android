package com.example.day2android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName;
    private Button btnNext;
    private ToggleButton btnToggle;
    private TextView txtColor;
    private Switch rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtName=findViewById(R.id.edtName);
        btnNext=findViewById(R.id.btnNext);
        txtColor=findViewById(R.id.txtColor);
        btnNext.setOnClickListener(this);
        rememberMe=findViewById(R.id.rememberMe);
        btnToggle=findViewById(R.id.btnStatus);
        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(rememberMe.isChecked())
                {
                    edtName.setText(edtName.getText().toString().toLowerCase());
                    txtColor.setBackgroundColor(Color.CYAN);
                    txtColor.setTextColor(Color.BLUE);
                }
                else
                {
                    edtName.setText(edtName.getText().toString().toUpperCase());
                    txtColor.setBackgroundColor(Color.YELLOW);
                    txtColor.setTextColor(Color.RED);
                }
            }
        });
        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
              if(btnToggle.isChecked())
              {
                  edtName.setText(edtName.getText().toString().toLowerCase());
                  txtColor.setBackgroundColor(Color.CYAN);
                  txtColor.setTextColor(Color.BLUE);
              }
              else
              {
                  edtName.setText(edtName.getText().toString().toUpperCase());
                  txtColor.setBackgroundColor(Color.YELLOW);
                  txtColor.setTextColor(Color.RED);
              }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(edtName.getText().length()!=0)
        {
            Intent nIntent=new Intent(FirstActivity.this,SecondActivity.class);
            nIntent.putExtra("name",edtName.getText().toString());
            startActivity(nIntent);
        }
        else
        {
            //edtName.setError("Enter Name");
            showAlert();
        }
    }
    private void showAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.ic_action_name);
        alertDialogBuilder.setTitle("Login Error");
        alertDialogBuilder.setMessage("Enter Your Name");
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialogBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog nAlertDialog=alertDialogBuilder.create();
        nAlertDialog.show();

    }
}
