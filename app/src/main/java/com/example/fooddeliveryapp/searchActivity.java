package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class searchActivity extends AppCompatActivity {
    private RecyclerView searchRecyclerView;
    private searchAdapter search_adapter;
    private SearchView searchView;
    Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar2=(Toolbar)findViewById(R.id.toolbarId2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        searchRecyclerView=findViewById(R.id.searchItmId);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        searchRecyclerView.setLayoutManager(linearLayoutManager);
        search_adapter= new searchAdapter(getListSearch());
        searchRecyclerView.setAdapter(search_adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbarmenu2,menu);
        SearchManager searchManager= (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView=(SearchView)menu.findItem(R.id.search2).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search Here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                search_adapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                search_adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //handle arrow click here
        if(item.getItemId()==android.R.id.home){
            finish();//close this activity and return to the previous activity(if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    private List<search> getListSearch() {
        List<search> list=new ArrayList<>();
        list.add(new search(R.drawable.bvg1,"bvg1"));
        list.add(new search(R.drawable.bvg2,"bvg2"));
        list.add(new search(R.drawable.bvg3,"bvg3"));
        list.add(new search(R.drawable.bvg4,"bvg4"));
        list.add(new search(R.drawable.bvg5,"bvg5"));
        list.add(new search(R.drawable.bvg6,"bvg6"));
        list.add(new search(R.drawable.bvg7,"bvg7"));
        list.add(new search(R.drawable.bvg8,"bvg8"));

        list.add(new search(R.drawable.frts1,"frts1"));//  list.add(new Food(R.drawable.frts1,"frts1",false));
        list.add(new search(R.drawable.frts2,"frts2"));
        list.add(new search(R.drawable.frts3,"frts3"));
        list.add(new search(R.drawable.frts4,"frts4"));
        list.add(new search(R.drawable.frts5,"frts5"));
        list.add(new search(R.drawable.frts6,"frts6"));

        list.add(new search(R.drawable.lnch1,"lnch1"));
        list.add(new search(R.drawable.lnch2,"lnch2"));
        list.add(new search(R.drawable.lnch3,"lnch3"));
        list.add(new search(R.drawable.lnch4,"lnch4"));
        list.add(new search(R.drawable.lnch5,"lnch5"));
        list.add(new search(R.drawable.lunchsix,"lnch6"));
        list.add(new search(R.drawable.lnch7,"lnch7"));

        list.add(new search(R.drawable.sf1,"sf1"));
        list.add(new search(R.drawable.sf2,"sf2"));
        list.add(new search(R.drawable.sf3,"sf3"));
        list.add(new search(R.drawable.sf4,"sf4"));
        list.add(new search(R.drawable.sf5,"sf5"));
        list.add(new search(R.drawable.sf6,"sf6"));
        return list;
    }

}