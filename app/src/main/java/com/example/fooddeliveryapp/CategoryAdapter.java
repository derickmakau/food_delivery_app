package com.example.fooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> implements Filterable {
private Context mContext;
private List<Category> mListCategory;
private List<Category> allmListCategory;

    public CategoryAdapter(Context mcontext,List<Category> mListCategory) {
        this.mContext=mcontext;
        this.allmListCategory= mListCategory;
        this.mListCategory= new ArrayList<>(allmListCategory);
    }

    public void setData(List<Category> list){
    this.mListCategory= list;
    this.allmListCategory=new ArrayList<>(list);
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
 holder.tvNameCategory.setText(category.getNameCategory());
 LinearLayoutManager linearLayoutManager= new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
 holder.rcvFood.setLayoutManager(linearLayoutManager);
 FoodAdapter foodAdapter= new FoodAdapter();
 foodAdapter.setData(category.getFoods());
 holder.rcvFood.setAdapter(foodAdapter);
}
@Override
    public int getItemCount(){
    if(mListCategory !=null){
        return mListCategory.size();
    }
    return 0;
}

    @Override
    public Filter getFilter() {

        return filter;
    }
Filter filter= new Filter(){
        //run on background thread
        @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
            List<Category> filteredList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(allmListCategory);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Category items : allmListCategory) {
                    if (items.toString().toLowerCase().contains(filterPattern))
                        filteredList.add(items);
                }
            }
            FilterResults results= new FilterResults();
            results.values = filteredList;
            results.count= filteredList.size();
            return results;

           /* List<Category> filteredList= new ArrayList<>();
            if(charSequence.toString().isEmpty()){
//check out this link for search. https://www.youtube.com/watch?v=Az-dhhEQXA8
                //filteredList.addAll(mListCategory);
                filteredList.addAll(allmListCategory);
            }
            else{
                allmListCategory=new ArrayList<>();
                for(Category items: allmListCategory){
                   if(items.toString().toLowerCase().contains(charSequence.toString().toLowerCase())){
                       filteredList.add(items);
                   }
                }
            }
            FilterResults filterResults= new FilterResults();
            filterResults.values=filteredList;
            return filterResults;*/
        }
        //runs on ui thread
        @Override
    protected void publishResults(CharSequence charSequence,FilterResults filterResults){
            FilterResults results= new FilterResults();
           /* mListCategory=new ArrayList<>();
            List<Category> filteredList= new ArrayList<>();
            filterResults= new FilterResults();
            filterResults.values=filteredList;*/
           // filterResults=new FilterResults();
mListCategory.clear();
if(results.values !=null)//check this just incase of error.
mListCategory.addAll((ArrayList)results.values);
notifyDataSetChanged();
        }
};
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
