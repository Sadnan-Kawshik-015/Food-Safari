package com.example.logintest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class CartDetails extends AppCompatActivity {

    private Button addToCart;
    private ImageView itemPic;
    private TextView itemName,itemDesc,itemPrice,itemStatus,itemRestaurant;
    private EditText itemQuantity;
    private CartProduct item;
    int item_quantity;
    String imageRes;
    String item_name,item_desc,item_price,item_status,item_restaurant_name,quantity,_price_;

    private DatabaseReference mDatabaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);
        //getSupportActionBar().setTitle("Item Details");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemName=findViewById(R.id.tv_cart_item_name);
        itemDesc=findViewById(R.id.tv_cart_item_desc);
        itemPrice=findViewById(R.id.tv_cart_item_price);
        itemStatus=findViewById(R.id.tv_cart_item_status);
        itemQuantity=findViewById(R.id.et_cart_item_quantity);
        addToCart=findViewById(R.id.btn_add_product_cart);
        itemPic=findViewById(R.id.iv_cart_item_img);
        itemRestaurant=findViewById(R.id.tv_cart_item_restaurant_name);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("User_Order");

        Intent intent=getIntent();
        //FoodData foodData=intent.getParcelableExtra("FoodItem");

        imageRes=intent.getStringExtra("Food_img");
        item_name=intent.getStringExtra("Food_name");
        item_desc=intent.getStringExtra("Food_Details");
        item_price=intent.getStringExtra("Food_price");
        item_status=intent.getStringExtra("Food_status");
        item_restaurant_name=intent.getStringExtra("Food_res_name");

        //itemPic.setImageResource(imageRes);
        Picasso.get().load(imageRes).placeholder(R.drawable.logo).fit().centerCrop().into(itemPic);
        itemName.setText(item_name);
        itemDesc.setText(item_desc);
        itemPrice.setText(item_price + " TK");
        itemStatus.setText(item_status);
        itemRestaurant.setText(item_restaurant_name);


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartDetails.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                quantity=itemQuantity.getText().toString();
                item_quantity=Integer.parseInt(quantity);
                item = new CartProduct(item_name,item_desc,item_price,imageRes,item_status,item_quantity,item_restaurant_name);
                mDatabaseRef.child(Constant.user_pass_).child(item_name).setValue(item);
                //item = new CartProduct(item_name,item_desc,item_price,imageRes,item_quantity,item_restaurant_name);
                //addCartProduct(item_name,item_desc,item_price,imageRes,quantity,item_restaurant_name);
                Log.e("QN",quantity);
                changeActivity(MyCart.class);



            }
        });
    }

    /*
    public void addCartProduct(String item_name,String item_desc,String item_price,String imageRes,String quantity,String item_restaurant_name)
    {

        item_quantity=Integer.parseInt(quantity);
        //int item_price_mod = Integer.parseInt(item_price);
        //item=new CartProduct(item_name,item_desc,item_price,imageRes,item_quantity,item_restaurant_name);

        mDatabaseRef.child("55555").setValue(item);



    }*/
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        //intent.putExtra("Player Choice",result);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(CartDetails.this,UserNewsFeed.class);
        startActivity(i);

    }

}