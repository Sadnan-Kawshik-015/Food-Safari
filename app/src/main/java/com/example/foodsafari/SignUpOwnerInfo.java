package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpOwnerInfo extends AppCompatActivity {

    private EditText ownName,ownEmail,ownEmail2,resName,resLocation;



    private Button spNextButton;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_owner_info);

        databaseReference = FirebaseDatabase.getInstance().getReference("Restaurant Owner");

        ownName = findViewById(R.id.spoi_name);
        ownEmail = findViewById(R.id.spoi_email);
        ownEmail2 = findViewById(R.id.spoi_email2);
        resName = findViewById(R.id.spoi_res_name);
        resLocation = findViewById(R.id.spoi_res_location);
        spNextButton = findViewById(R.id.spoi_next_button);



        spNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email  = ownEmail.getText().toString();
                String email2  = ownEmail2.getText().toString();

                if(Patterns.EMAIL_ADDRESS.matcher(email).matches() && email2.length()==6){

                    saveData();

                    startActivity(new Intent(SignUpOwnerInfo.this,UploadImageFB.class));

                    /*
                    Intent i = new Intent(SignUpOwnerInfo.this,RestaurantInfo.class);

                    i.putExtra("userName",ownName.getText().toString());
                    i.putExtra("email",ownEmail.getText().toString());
                    i.putExtra("resName",resName.getText().toString());
                    i.putExtra("resLoc",resLocation.getText().toString());

                    startActivity(i);
                    */

                    //startActivity(new Intent(SignUpOwnerInfo.this,CaptureImage.class));

                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    ownEmail.setError("Invalid email");
                    ownEmail.requestFocus();

                }
                if(email2.length()!=6) {

                    ownEmail2.setError("Invalid NID. Length must be of 6 digits");
                    ownEmail2.requestFocus();

                }


            }
        });
    }

    public void saveData(){

        String name = ownName.getText().toString().trim();


        String Email = ownEmail.getText().toString().trim();


        String email2 = ownEmail2.getText().toString().trim();


        String rName = resName.getText().toString().trim();


        String rLocation = resLocation.getText().toString().trim();


        //String key = databaseReference.push().getKey();

        //String key = email2;

        String key = Constant.res_owner_pass;

        RestaurantOwnerInfo owner = new RestaurantOwnerInfo(name,Email,rName,rLocation);

        databaseReference.child(key).setValue(owner);

        Toast.makeText(SignUpOwnerInfo.this,"Information has been updated",Toast.LENGTH_LONG).show();



    }

}
