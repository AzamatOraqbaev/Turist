package com.example.turist.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.turist.Domains.PopularDomain;
import com.example.turist.R;


public class DetailActivity extends AppCompatActivity {

    private TextView titleTxt, locationTxt, bedTxt, guideTxt, wifiTxt, descriptionTxt, scoreTxt;
    private PopularDomain item;
    private ImageView picImg, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        itemView();
        setVariable();
    }

    private void setVariable() {
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        titleTxt.setText(item.getTitle());
        scoreTxt.setText(String.valueOf(item.getScore())); // Convert int to String for setText
        locationTxt.setText(item.getLocation());
        bedTxt.setText(item.getBed() + " орын");
        descriptionTxt.setText(item.getDescription());

        guideTxt.setText(item.isGuide() ? "Guide" : "NO-Guide");
        wifiTxt.setText(item.isWifi() ? "WIFI" : "NO-WIFI");

        int drawableResId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());
        Glide.with(this)
                .load(drawableResId)
                .into(picImg);

        backBtn.setOnClickListener(v -> finish());
    }

    private void itemView() {
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        bedTxt = findViewById(R.id.bedTxt);
        guideTxt = findViewById(R.id.guideTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        picImg = findViewById(R.id.picImg);
        backBtn = findViewById(R.id.backBtn);
    }
}
