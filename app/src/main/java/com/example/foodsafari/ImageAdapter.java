package com.example.logintest;


import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload_Food> mUploads;

    public ImageAdapter(Context context, List<Upload_Food> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload_Food uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        holder.textViewResName.setText(uploadCurrent.getDate());
        holder.textViewFoodPrice.setText("Price: "+uploadCurrent.getPrice()+"$");
        if(uploadCurrent.getStatus() == 1)holder.textViewFoodStatus.setText("Available");
        else if(uploadCurrent.getStatus() == 0) holder.textViewFoodStatus.setText("Inavailable");
        Picasso.get().load(uploadCurrent.getImageUrl()).placeholder(R.drawable.logo).fit().centerCrop().into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName,textViewResName,textViewFoodPrice,textViewFoodStatus;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.tv_item_title2);
            textViewResName = itemView.findViewById(R.id.tv_item_details2);
            textViewFoodPrice = itemView.findViewById(R.id.tv_item_price2);
            textViewFoodStatus = itemView.findViewById(R.id.tv_item_status2);
            imageView = itemView.findViewById(R.id.iv_food_item2);
        }
    }
}