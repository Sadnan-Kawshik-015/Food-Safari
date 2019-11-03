package com.example.foodsafarifinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DiscountFragment extends Fragment {

    /**Still haven't done the work in this.Anyone want to do just let me know**/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Log.i("whaee", "")

        return inflater.inflate(R.layout.fragment_discount,container,false);
    }
}
