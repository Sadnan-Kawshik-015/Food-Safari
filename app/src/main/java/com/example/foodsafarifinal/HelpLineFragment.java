package com.example.foodsafarifinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HelpLineFragment extends Fragment {


    TextView url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_helpline,container,false);

        url=view.findViewById(R.id.tv_helpline_link);
        final String link="https://sites.google.com/view/foodsafariproject/home";
        SpannableString ss=new SpannableString(link);
        UnderlineSpan underlineSpan=new UnderlineSpan();
        ss.setSpan(underlineSpan,0,ss.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        url.setText(ss);
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickURL(link);
            }
        });


        return view;

    }
    public void clickURL(String url)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
