package com.example.foodsafarifinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shivtechs.maplocationpicker.LocationPickerActivity;
import com.shivtechs.maplocationpicker.MapUtility;

public class OrderFinalization extends AppCompatActivity {
     EditText nameEditText,phoneEditText;
     TextView addressText;
     Button confirmOrderButton;
    private static final int ADDRESS_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finalization);

        getSupportActionBar().setTitle("Order Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MapUtility.apiKey = getResources().getString(R.string.api_key);


        confirmOrderButton=findViewById(R.id.btn_confirm_order);
        nameEditText=findViewById(R.id.et_order_finalization_receiver_name);
        phoneEditText=findViewById(R.id.et_order_finalization_receiver_phone_number);
        addressText=findViewById(R.id.tv_order_finalization_receiver_address);

        addressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(OrderFinalization.this, LocationPickerActivity.class);
                startActivityForResult(intent, ADDRESS_PICKER_REQUEST);
            }
        });


        confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Here a intent will be created that will guide me to the
                 * payment activity**/

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADDRESS_PICKER_REQUEST) {
            try {
                if (data != null && data.getStringExtra(MapUtility.ADDRESS) != null) {
                    String address = data.getStringExtra(MapUtility.ADDRESS);
                    double currentLatitude = data.getDoubleExtra(MapUtility.LATITUDE, 0.0);
                    double currentLongitude = data.getDoubleExtra(MapUtility.LONGITUDE, 0.0);

                    addressText.setText(address);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}
