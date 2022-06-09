package com.example.fooddeliveryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class favoriteAdapter extends RecyclerView.Adapter<favoriteAdapter.favoriteViewHolder>{
    public List<favoriteitems> favourite;
   /* public favoriteAdapter(List<favoriteitems> favourite){

        this.favourite= favourite;
    }*/
    public void setData(List<favoriteitems> favourite){
        this.favourite= favourite;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public favoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favouriteitem,parent,false);
        return new favoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull favoriteAdapter.favoriteViewHolder holder, int position) {
        favoriteitems favoriteOne=favourite.get(position);
        if(favoriteOne==null){
            return;
        }
        holder.imageViewOne.setImageResource(favoriteOne.getImageId());
        holder.textViewOne.setText(favoriteOne.getName());
    }

    @Override
    public int getItemCount() {
        if(favourite != null){
            return favourite.size();
        }
        return 0;
    }

    public class favoriteViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewOne;
        private TextView textViewOne;
        private RatingBar ratingBar;
        public favoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewOne=itemView.findViewById(R.id.circleImageId);
            textViewOne=itemView.findViewById(R.id.titleId);
            ratingBar= itemView.findViewById(R.id.ratingId);
            /*ratingBar.setOnRatingBarChangeListener(RatingBar ratingBar, float v, boolean fromUser){

            }*/
        }
    }
}
