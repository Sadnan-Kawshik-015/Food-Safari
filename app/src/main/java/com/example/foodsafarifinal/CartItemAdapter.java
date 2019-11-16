package com.example.foodsafarifinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {

        holder.cart_item_title.setText("Item Name : "+myCartList.get(position).getFoodName());
        holder.cart_item_quantity.setText("Quantity : "+Integer.toString(myCartList.get(position).getQuantity()));
        holder.cart_item_price.setText("Price : "+myCartList.get(position).getFoodPrice()+" Taka ");
        holder.cart_item_restaurant_name.setText("Ordered From : "+myCartList.get(position).getRestaurantName());

    }

    @Override
    public int getItemCount() {
        return myCartList.size();
    }
}

class CartItemViewHolder extends RecyclerView.ViewHolder {

    /**Used to hold the view for the recyler_menu_row which is how every menu item will look like**/

    TextView cart_item_title,cart_item_price,cart_item_quantity,cart_item_restaurant_name;
    RelativeLayout cart_layout;

    public CartItemViewHolder( View itemView) {
        super(itemView);

        cart_item_title=itemView.findViewById(R.id.tv_my_cart_item_name);
        cart_item_price=itemView.findViewById(R.id.tv_my_cart_item_price);
        cart_item_quantity=itemView.findViewById(R.id.tv_my_cart_item_quantity);
        cart_item_restaurant_name=itemView.findViewById(R.id.tv_my_cart_item_restaurant_name);
       // cart_layout=itemView.findViewById(R.id.rl_my_cart);


    }
}
