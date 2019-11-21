package com.example.logintest;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OrderFinalization extends AppCompatActivity {
    EditText nameEditText,phoneEditText;
    TextView addressText;
    Button confirmOrderButton;
    int PLACE_PICKER_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finalization);

        //getSupportActionBar().setTitle("Order Details");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        confirmOrderButton=findViewById(R.id.btn_confirm_order);
        nameEditText=findViewById(R.id.et_order_finalization_receiver_name);
        phoneEditText=findViewById(R.id.et_order_finalization_receiver_phone_number);
        addressText=findViewById(R.id.et_order_finalization_receiver_address);


        confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Here a intent will be created that will guide me to the
                 * payment activity**/

                Intent i = new Intent(OrderFinalization.this,Payment_Choice.class);
                startActivity(i);

            }
        });
    }


}