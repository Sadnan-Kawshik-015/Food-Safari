package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class RestaurantSettings extends AppCompatActivity implements UsernameChangeDialog.UsernameChangeDialogListener, PasswordChangeDialog.PasswordChangeDialogListener, LocationChangeDialog.LocationChangeDialogListener {
    Button btn_user_name_change,btn_user_password_change,btn_user_location_change;
    TextView tv_user_name_change,tv_user_password_change,tv_user_location_change;

    /**The settings option for restaurant owner**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_settings);

        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_user_name_change=findViewById(R.id.btn_change_user_name);
        btn_user_password_change=findViewById(R.id.btn_change_user_password);
        btn_user_location_change=findViewById(R.id.btn_change_location);

        tv_user_name_change=findViewById(R.id.tv_user_name_change);
        tv_user_password_change=findViewById(R.id.tv_user_password_change);
        tv_user_location_change=findViewById(R.id.tv_user_location_change);
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

        Toast.makeText(RestaurantSettings.this,username+" is set as new username",Toast.LENGTH_SHORT).show();
        /**We will store updated user name,password and location in this portion**/

    }

    @Override
    public void applyText(String password) {

        Toast.makeText(RestaurantSettings.this,password+" is set",Toast.LENGTH_SHORT).show();
        /**We will store updated user name,password and location in this portion.Check parameter for details**/

    }

    @Override
    public void applyLocation(String location) {

        Toast.makeText(RestaurantSettings.this,location+" is set as new address",Toast.LENGTH_SHORT).show();
        /**We will store updated user name,password and location in this portion**/
    }
}
