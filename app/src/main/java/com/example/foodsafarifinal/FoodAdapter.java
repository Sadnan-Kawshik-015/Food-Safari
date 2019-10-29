package com.example.foodsafarifinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*Adapter class for every menu item after the restaurant list**/

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder>{

    private Context mContext;
    private List<FoodData>myFoodList;/**List that contains item type of Food*/
    private int lastPosition=-1;


    public FoodAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_menu_row,parent,false);

        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        /**Used to set the values in the menu item template. Each menu item wil be stored under restaurants.Layout file for this
         * is recyler_menu_row.You can give suggestion if any change to suggest.**/

        holder.menU_img.setImageResource(myFoodList.get(position).getFoodImage());
        holder.menu_title.setText(myFoodList.get(position).getFoodName());
        holder.menu_description.setText(myFoodList.get(position).getFoodDetails());
        holder.menu_price.setText(myFoodList.get(position).getFoodPrice());
        holder.menu_status.setText(myFoodList.get(position).getActiveStatus());

        setAnimation(holder.itemView,position);
    }
    public void setAnimation(View viewToAnimate,int position)
    {
        if (position>lastPosition)
        {
            ScaleAnimation scaleAnimation=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

            scaleAnimation.setDuration(1000);
            viewToAnimate.startAnimation(scaleAnimation);
            lastPosition=position;
        }
    }
    @Override
    public int getItemCount() {
        return myFoodList.size();
    }
}


class FoodViewHolder extends RecyclerView.ViewHolder {

    /**Used to hold the view for the recyler_menu_row which is how every menu item will look like**/
    ImageView menU_img;
    TextView menu_title,menu_description,menu_price,menu_status;
    CardView menu_card;
    public FoodViewHolder( View itemView) {
        super(itemView);

        menU_img=itemView.findViewById(R.id.iv_food_item);
        menu_title=itemView.findViewById(R.id.tv_item_title);
        menu_description=itemView.findViewById(R.id.tv_item_details);
        menu_price=itemView.findViewById(R.id.tv_item_price);
        menu_status=itemView.findViewById(R.id.tv_item_status);
        menu_card=itemView.findViewById(R.id.cv_menu_details);
    }
}
