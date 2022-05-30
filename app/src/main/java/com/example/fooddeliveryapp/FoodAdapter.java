package com.example.fooddeliveryapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.widget.Toast.*;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    public List<Food> sFood;
    public List<Food> sFoodAll;
    public Context context;


    public void setData(List<Food> list){
        this.sFood=list;
        this.sFoodAll= list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        context=parent.getContext();
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
holder.  linearLayoutOne.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        Log.d("success","added to cart");
        Toast.makeText(view.getContext(),"added to cart",Toast.LENGTH_SHORT).show();
        cart newCartFragment= new cart();
        FragmentManager fragmentManager= ((AppCompatActivity)context).getSupportFragmentManager();//((AppCompatActivity)context)
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container,newCartFragment);
        fragmentTransaction.commit();
    }
});
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
        private LinearLayout linearLayoutOne, linearLayoutTwo;
        private CardView cardViewOne;
        public FoodViewHolder(@NonNull View itemView){
            super(itemView);
            imgFood=itemView.findViewById(R.id.img_food);
            tvTitle=itemView.findViewById(R.id.tv_title);
            linearLayoutOne=itemView.findViewById(R.id.hideCartId);
            linearLayoutTwo= itemView.findViewById(R.id.hideLikeId);
            cardViewOne= itemView.findViewById(R.id.cardViewId);
            linearLayoutTwo.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View view){
                   Log.d("success","added to favourites");
                   Toast.makeText(view.getContext(),"added to Favourites",Toast.LENGTH_SHORT).show();
               }
            });
        }
    }
}
