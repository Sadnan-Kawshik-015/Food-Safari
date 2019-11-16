package com.example.foodsafarifinal;

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

public class CartDetails extends AppCompatActivity {

    private Button addToCart;
    private ImageView itemPic;
    private TextView itemName,itemDesc,itemPrice,itemStatus,itemRestaurant;
    private EditText itemQuantity;
    private CartProduct item;
    int imageRes,item_quantity;
    String item_name,item_desc,item_price,item_status,item_restaurant_name,quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);
        getSupportActionBar().setTitle("Item Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemName=findViewById(R.id.tv_cart_item_name);
        itemDesc=findViewById(R.id.tv_cart_item_desc);
        itemPrice=findViewById(R.id.tv_cart_item_price);
        itemStatus=findViewById(R.id.tv_cart_item_status);
        itemQuantity=findViewById(R.id.et_cart_item_quantity);
        addToCart=findViewById(R.id.btn_add_product_cart);
        itemPic=findViewById(R.id.iv_cart_item_img);
        itemRestaurant=findViewById(R.id.tv_cart_item_restaurant_name);

        Intent intent=getIntent();
        FoodData foodData=intent.getParcelableExtra("FoodItem");

        imageRes=foodData.getFoodImage();
        item_name=foodData.getFoodName();
        item_desc=foodData.getFoodDetails();
        item_price=foodData.getFoodPrice();
        item_status=foodData.getActiveStatus();
        item_restaurant_name=foodData.getRestaurantName();

        itemPic.setImageResource(imageRes);
        itemName.setText(item_name);
        itemDesc.setText(item_desc);
        itemPrice.setText(item_price);
        itemStatus.setText(item_status);
        itemRestaurant.setText(item_restaurant_name);


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartDetails.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                quantity=itemQuantity.getText().toString();
                Log.e("QN",quantity);
                //changeActivity(MyCart.class);
                //addCartProduct(quantity);


            }
        });
    }

    public void addCartProduct(String quantity)
    {

        item_quantity=Integer.parseInt(quantity);
        item=new CartProduct(item_name,item_desc,item_price,imageRes,item_quantity,item_restaurant_name);

        /**ADD ITEM TO DATABASE**/

    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        //intent.putExtra("Player Choice",result);
        startActivity(intent);
        //finish();
    }



}
