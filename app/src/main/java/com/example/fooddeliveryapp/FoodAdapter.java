package com.example.fooddeliveryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.widget.Toast.*;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> sFood;
    public void setData(List<Food> list){
        this.sFood=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
Food food=sFood.get(position);
if(food==null){
    return;
}
holder.imgFood.setImageResource(food.getResourceId());
holder.tvTitle.setText(food.getTitle());
    }

    @Override
    public int getItemCount() {
        if(sFood !=null){
            return sFood.size();
        }
        return 0;
    }
    public class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView tvTitle;
        public FoodViewHolder(@NonNull View itemView){
            super(itemView);
            imgFood=itemView.findViewById(R.id.img_food);
            tvTitle=itemView.findViewById(R.id.tv_title);
        }
    }
}
