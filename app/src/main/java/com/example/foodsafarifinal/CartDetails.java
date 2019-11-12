package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    private TextView itemName,itemDesc,itemPrice,itemStatus;
    private EditText itemQuantity;
    private CartProduct item;
    int imageRes,item_quantity;
    String item_name,item_desc,item_price,item_status;


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

        Intent intent=getIntent();
        FoodData foodData=intent.getParcelableExtra("FoodItem");

        imageRes=foodData.getFoodImage();
        item_name=foodData.getFoodName();
        item_desc=foodData.getFoodDetails();
        item_price=foodData.getFoodPrice();
        item_status=foodData.getActiveStatus();
        item_quantity=Integer.parseInt(itemQuantity.getText().toString());

        itemPic.setImageResource(imageRes);
        itemName.setText(item_name);
        itemDesc.setText(item_desc);
        itemPrice.setText(item_price);
        itemStatus.setText(item_status);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartDetails.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                addItemCart();

            }
        });
    }
    public void addItemCart()
    {
        item=new CartProduct(item_name,item_desc,item_price,imageRes,item_quantity);
        /**Use firebase to store cartItem**/
    }
}
