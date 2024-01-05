package com.example.turist.Adapters;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.turist.Activities.DetailActivity;
import com.example.turist.Domains.PopularDomain;
import com.example.turist.R;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<PopularDomain> items;


    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;

    }
    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflante = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflante);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.locationTxt.setText(items.get(position).getLocation());
        holder.scoreTxt.setText(""+items.get(position).getScore());

        int drawableResId=holder.itemView.getResources().getIdentifier(items.get(position).getPic(),
                "drawable", holder.itemView.getContext().getPackageName());


        Glide.with(holder.itemView.getContext())
                .load(drawableResId)
                .transform(new CenterCrop(),new GranularRoundedCorners(40,40,40,40))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object",items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt,locationTxt,scoreTxt;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTxt=itemView.findViewById(R.id.titleTxt);
            locationTxt=itemView.findViewById(R.id.locationTxt);
            scoreTxt=itemView.findViewById(R.id.scoreTxt);
            pic=itemView.findViewById(R.id.picImg);
        }
    }
}
