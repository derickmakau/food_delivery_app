package com.example.fooddeliveryapp;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.SearchViewHolder> implements Filterable {
        public  List<search> searches;
        public List<search> allSearches;

        public searchAdapter(List<search> list){
            this.searches=list;
            this.allSearches= list;

        }
        @NonNull
        @Override
        public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsearched,parent,false);
            return new SearchViewHolder (view);
        }

        @Override
        public void onBindViewHolder(@NonNull searchAdapter.SearchViewHolder holder, int position) {
            search searc=searches.get(position);
            if(searc==null){
                return;
            }
            holder.imgFood2.setImageResource(searc.getResourceId());//searc.getResourceId()
            holder.tvTitle2.setText(searc.getTitle());
            holder.  linearLayoutOne2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Log.d("success","added to cart");
                    Toast.makeText(view.getContext(),"added to cart",Toast.LENGTH_SHORT).show();


                }
            });
            holder.   linearLayoutTwo2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Log.d("success","added to favourites");
                    Toast.makeText(view.getContext(),"added to Favourites",Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            if(searches !=null){
                return searches.size();
            }
            return 0;
        }

    @Override
    public Filter getFilter() {
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence constraint){
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    searches=allSearches;

                }
                else{
                    List<search> list=new ArrayList<>();
                    for(search search:allSearches){
                        if(search.getTitle().toLowerCase().contains(strSearch.toLowerCase())){
list.add(search);
                        }
                    }
                    searches=list;
                }
                FilterResults filterResults= new FilterResults();
                filterResults.values= searches;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results){
                searches=(List<search>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
            private ImageView imgFood2;
            private TextView tvTitle2;
            private LinearLayout linearLayoutOne2, linearLayoutTwo2;
            private CardView cardViewOne2;
            private Resources resources;
            public SearchViewHolder(@NonNull View itemView){
                super(itemView);
                resources = itemView.getContext().getResources();
                imgFood2=itemView.findViewById(R.id.img_food2);
                tvTitle2=itemView.findViewById(R.id.tv_title2);
                linearLayoutOne2=itemView.findViewById(R.id.hideCartId2);
                linearLayoutTwo2= itemView.findViewById(R.id.hideLikeId2);
                cardViewOne2= itemView.findViewById(R.id.cardViewId2);
            }
        }

}
