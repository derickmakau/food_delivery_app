package com.example.fooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
private Context mContext;
private List<Category> mListCategory;


    public CategoryAdapter(Context mcontext,List<Category> mListCategory) {
        this.mContext=mcontext;
        this.mListCategory= mListCategory;

    }

    public void setData(List<Category> list){
    this.mListCategory= list;
    notifyDataSetChanged();
}
@NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent,false);
    return new CategoryViewHolder(view);
}
@Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position){
        Category category=mListCategory.get(position);
 if(category== null){
    return;
 }
 holder.tvNameCategory.setText(category.getNameCategory());//getNameCategory()
 LinearLayoutManager linearLayoutManager= new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
 holder.rcvFood.setLayoutManager(linearLayoutManager);
 FoodAdapter categoryAdapter= new FoodAdapter();
 categoryAdapter.setData(category.getFoods());
 holder.rcvFood.setAdapter(categoryAdapter);
}
@Override
    public int getItemCount(){
    if(mListCategory !=null){
        return mListCategory.size();
    }
    return 0;
}
    public class CategoryViewHolder extends RecyclerView.ViewHolder{
    private TextView tvNameCategory;
    private RecyclerView rcvFood;
    public CategoryViewHolder(@NonNull View itemView){
        super(itemView);
        tvNameCategory= itemView.findViewById(R.id.categoryId);
        rcvFood= itemView.findViewById(R.id.recyclerId);
    }
}
}
