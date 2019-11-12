package com.example.logintest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RestaurantSettings extends AppCompatActivity implements UsernameChangeDialog.UsernameChangeDialogListener, PasswordChangeDialog.PasswordChangeDialogListener, LocationChangeDialog.LocationChangeDialogListener {

    DatabaseReference ref,ref2;

    Button btn_user_name_change,btn_user_password_change,btn_user_location_change;
    TextView tv_user_name_change,tv_user_password_change,tv_user_location_change;

    /**The settings option for restaurant owner**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_settings);

        //getSupportActionBar().setTitle("Settings");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_user_name_change=findViewById(R.id.btn_change_user_name);
        btn_user_password_change=findViewById(R.id.btn_change_user_password);
        btn_user_location_change=findViewById(R.id.btn_change_location);

        tv_user_name_change=findViewById(R.id.tv_user_name_change);
        tv_user_password_change=findViewById(R.id.tv_user_password_change);
        tv_user_location_change=findViewById(R.id.tv_user_location_change);

        //String own_user_name,own_email,res_name,res_loc;

        ref = FirebaseDatabase.getInstance().getReference().child("Restaurant Owner").child(Constant.res_owner_pass);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //String own_name = dataSnapshot.child("name").getValue().toString();
                String own_user_name = dataSnapshot.child("name").getValue().toString();
                String own_email = dataSnapshot.child("email").getValue().toString();
                String res_name = dataSnapshot.child("rName").getValue().toString();
                String res_loc = dataSnapshot.child("rLocation").getValue().toString();

                Constant.res_owner_user_name = own_user_name;
                Constant.res_owner_email = own_email;
                Constant.res_owner_res_name = res_name;
                Constant.res_owner_res_loc = res_loc;

                //for(DataSnapshot post)


                Toast.makeText(RestaurantSettings.this,"Your Profile",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(RestaurantSettings.this,"Error ocurred",Toast.LENGTH_LONG).show();

            }

        });

        tv_user_name_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantSettings.this,"Name Change",Toast.LENGTH_SHORT).show();
                openDialogUserName();
            }
        });
        tv_user_password_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantSettings.this,"Password Change",Toast.LENGTH_SHORT).show();
                openDialogPassword();
            }
        });
        tv_user_location_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantSettings.this,"Password Change",Toast.LENGTH_SHORT).show();
                openDialogLocation();
            }
        });
    }
    public void openDialogUserName()
    /**It will open the User name change dialog box**/
    {
        UsernameChangeDialog usernameChangeDialog=new UsernameChangeDialog();
        usernameChangeDialog.show(getSupportFragmentManager(),"Update User Name");
    }
    public void openDialogPassword()
    {
        PasswordChangeDialog passwordChangeDialog=new PasswordChangeDialog();
        passwordChangeDialog.show(getSupportFragmentManager(),"Update Password");
    }
    public void openDialogLocation()
    {
        LocationChangeDialog locationChangeDialog=new LocationChangeDialog();
        locationChangeDialog.show(getSupportFragmentManager(),"Update Location");
    }
    @Override
    public void applyTexts(String username) {


        String key = Constant.res_owner_pass;

        Constant.res_owner_user_name = username;

        RestaurantOwnerInfo owner = new RestaurantOwnerInfo(Constant.res_owner_user_name,Constant.res_owner_email,Constant.res_owner_email,Constant.res_owner_res_loc);

        ref2 = FirebaseDatabase.getInstance().getReference("Restaurant Owner");

        ref2.child(key).setValue(owner);

        Toast.makeText(RestaurantSettings.this,username+" is set as new username",Toast.LENGTH_SHORT).show();

        Toast.makeText(RestaurantSettings.this,"Information has been updated",Toast.LENGTH_LONG).show();
        /**We will store updated user name,password and location in this portion**/

    }

    @Override
    public void applyText(String password) {

        Toast.makeText(RestaurantSettings.this,password+" is set",Toast.LENGTH_SHORT).show();
        /**We will store updated user name,password and location in this portion.Check parameter for details**/

    }

    @Override
    public void applyLocation(String location) {

        String key = Constant.res_owner_pass;

        Constant.res_owner_res_loc = location;

        RestaurantOwnerInfo owner = new RestaurantOwnerInfo(Constant.res_owner_user_name,Constant.res_owner_email,Constant.res_owner_email,Constant.res_owner_res_loc);

        ref2 = FirebaseDatabase.getInstance().getReference("Restaurant Owner");

        ref2.child(key).setValue(owner);

        Toast.makeText(RestaurantSettings.this,location+" is set as new address",Toast.LENGTH_SHORT).show();

        Toast.makeText(RestaurantSettings.this,"Information has been updated",Toast.LENGTH_LONG).show();
        /**We will store updated user name,password and location in this portion**/
    }

}

