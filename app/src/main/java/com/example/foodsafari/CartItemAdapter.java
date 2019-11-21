package com.example.logintest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemViewHolder>{

    Context mContext;
    private List<CartProduct> myCartList;/**List that contains item type of Food*/



    public CartItemAdapter(Context mContext, List<CartProduct> myCartList) {
        this.mContext = mContext;
        this.myCartList = myCartList;
    }

    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart_item,parent,false);

        return new CartItemViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, final int position) {

        holder.cart_item_title.setText("Item Name : "+myCartList.get(position).getFoodName());
        holder.cart_item_quantity.setText("Quantity : "+Integer.toString(myCartList.get(position).getQuantity()));
        holder.cart_item_price.setText("Price : "+myCartList.get(position).getFoodPrice()+" Taka ");
        holder.cart_item_restaurant_name.setText("Ordered From : "+myCartList.get(position).getRestaurantName());

        Picasso.get().load(myCartList.get(position).getFoodImage()).placeholder(R.drawable.logo).fit().centerCrop().into(holder.cart_item_img);


        holder.cart_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence options[]=new CharSequence[]
                        {
                                "Edit",
                                "Remove"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                builder.setTitle("Cart Options");

                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        if(i==0)
                        {
                            /*Intent intent=new Intent(mContext,CartDetails.class);
                            intent.putExtra("pName",myCartList.get(position).getFoodName());
                            mContext.startActivity(intent);*/
                            /**It will go to the cart details activity to edit information of cart item such as quantity and show
                             * it to cart.Any approach will be appreciated as I am a little confused**/
                        }
                        if (i==1)
                        {
                            /**Delete the activity from order list**/
                            Toast.makeText(mContext,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return myCartList.size();
    }
}

class CartItemViewHolder extends RecyclerView.ViewHolder {

    /**Used to hold the view for the recyler_menu_row which is how every menu item will look like**/

    TextView cart_item_title,cart_item_price,cart_item_quantity,cart_item_restaurant_name;
    CardView cart_item;
    ImageView cart_item_img;

    public CartItemViewHolder( View itemView) {
        super(itemView);

        cart_item_title=itemView.findViewById(R.id.tv_my_cart_item_name);
        cart_item_price=itemView.findViewById(R.id.tv_my_cart_item_price);
        cart_item_quantity=itemView.findViewById(R.id.tv_my_cart_item_quantity);
        cart_item_restaurant_name=itemView.findViewById(R.id.tv_my_cart_item_restaurant_name);
        cart_item_img = itemView.findViewById(R.id.iv_chc_food_item_image);
        cart_item=itemView.findViewById(R.id.cv_cart_item);



    }

}

