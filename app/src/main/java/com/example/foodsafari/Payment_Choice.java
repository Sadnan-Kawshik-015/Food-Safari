package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment_Choice extends AppCompatActivity {

    TextView tv;
    Button btn_paypal,btn_card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__choice);

        tv = findViewById(R.id.tv_price);
        btn_paypal = findViewById(R.id.btn_paypal_chc);
        btn_card = findViewById(R.id.btn_card_chc);

        tv.setText(Constant.cost + " TK");

        btn_paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Payment_Choice.this,Paypal.class);
                startActivity(i);

            }
        });
    }
}
