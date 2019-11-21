package com.example.logintest;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Paypal extends AppCompatActivity {

    EditText et_email,et_pass;
    Button btn_login_pl;
    ProgressDialog progressDialog ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);

        et_email = findViewById(R.id.pl_email);
        et_pass = findViewById(R.id.pl_pass);
        btn_login_pl = findViewById(R.id.pl_login_button);
        progressDialog = new ProgressDialog(Paypal.this);// context name as per your project name

        btn_login_pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for(int i=0;i<9000;++i){

                    progressDialog.setTitle("Please wait");
                    progressDialog.show();
                }
                //progressDialog.dismiss();

                Intent i = new Intent(Paypal.this,Dummy_test.class);
                startActivity(i);


            }
        });
    }
}
