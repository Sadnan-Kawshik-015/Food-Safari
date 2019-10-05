package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpOwnerInfo extends AppCompatActivity {

    private EditText ownName,ownEmail,resName,resLocation;

    private Button spNextButton;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_owner_info);

        databaseReference = FirebaseDatabase.getInstance().getReference("Restaurant Owner");

        ownName = findViewById(R.id.spoi_name);
        ownEmail = findViewById(R.id.spoi_email);
        resName = findViewById(R.id.spoi_res_name);
        resLocation = findViewById(R.id.spoi_res_location);
        spNextButton = findViewById(R.id.spoi_next_button);

        spNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();

                startActivity(new Intent(SignUpOwnerInfo.this,HomeActivity.class));

            }
        });
    }

    public void saveData(){

        String name = ownName.getText().toString().trim();
        String email = ownEmail.getText().toString().trim();
        String rName = resName.getText().toString().trim();
        String rLocation = resLocation.getText().toString().trim();

        String key = databaseReference.push().getKey();

        RestaurantOwnerInfo owner = new RestaurantOwnerInfo(name,email,rName,rLocation);

        databaseReference.child(key).setValue(owner);

        Toast.makeText(SignUpOwnerInfo.this,"Information has been updated",Toast.LENGTH_LONG).show();


    }
}
