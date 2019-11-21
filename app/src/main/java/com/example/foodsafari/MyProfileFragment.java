package com.example.logintest;

/*import androidx.fragment.app.Fragment;

public class MyProfileFragment extends Fragment {
}
*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyProfileFragment extends Fragment {

    TextView user_name,email,location;
    ImageView user_pic;
    Person user;


    @Nullable
    @Override

    /**User profile fragment **/

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_profile,container,false);
        user_name=view.findViewById(R.id.tv_user_profile_user_name);
        email=view.findViewById(R.id.tv_user_profile_user_email);
        location=view.findViewById(R.id.tv_user_profile_user_location);
        user_pic=view.findViewById(R.id.iv_user_image);

        /*Data retrieve and show
        user_name.setText("");
        email.setText("");
        location.setText("");
        //user_pic.setImageBitmap();*/
        return view;
    }
}