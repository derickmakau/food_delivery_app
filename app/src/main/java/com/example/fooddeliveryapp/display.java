package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class display extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
BottomNavigationView navigationView;
Toolbar toolbar;
CategoryAdapter categoryAdapter;
List<Category> mListCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        loadFragment(new cart());
        toolbar=(Toolbar)findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.bottomNavigationViewId);
        navigationView.setOnNavigationItemSelectedListener(this);
        mListCategory= new ArrayList<>();
        /*handleIntent(getIntent());*/
    }
    /*@Override
    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }*/
   private boolean loadFragment(Fragment fragment){
        if(fragment !=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
            return true;
        }
        return false;
   }
   @Override
   public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater=getMenuInflater();
                inflater.inflate(R.menu.toolbarmenu,menu);
       MenuItem item= menu.findItem(R.id.search);
       SearchView searchView=(SearchView) item.getActionView();
       searchView.setQueryHint("Search Here");
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
           @Override
           public boolean onQueryTextSubmit(String query){

               return false;
           }
           @Override
           public boolean onQueryTextChange(String newText){
               categoryAdapter= new CategoryAdapter(display.this,mListCategory);
               categoryAdapter.getFilter().filter(newText);

               return false;
           }
       });
               /* MenuItem item= menu.findItem(R.id.search);
                SearchView searchView=(SearchView) item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
                    @Override
                    public boolean onQueryTextSubmit(String query){
                       return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String newText){
                        CategoryAdapter.getFilter().filter(newText);

                        return false;
                    }
                });*/
        return true;
   }
   @Override
   public boolean onOptionsItemSelected(MenuItem item){
       switch(item.getItemId()){
           case R.id.signinId:
               Intent signinIntent=new Intent(display.this,login.class);
               startActivity(signinIntent);
               break;
           case R.id.signupId:
               Intent signupIntent=new Intent(display.this, registerScreen.class);
               startActivity(signupIntent);
               break;
           case R.id.logoutId:
               Intent mainIntent=new Intent(display.this, MainActivity.class);
               startActivity(mainIntent);
               //MenuItem item= menu.findItem(R.id.search);
               /*SearchView searchView=(SearchView) item.getActionView();
               searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
                   @Override
                   public boolean onQueryTextSubmit(String query){
                       return false;
                   }
                   @Override
                   public boolean onQueryTextChange(String newText){
                       CategoryAdapter.getFilter().filter(newText);

                       return false;
                   }
               });*/

       }
       return super.onOptionsItemSelected(item);

   }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       Fragment fragment=null;
       switch(item.getItemId()){
           case R.id.cartId:
               fragment = new cart();
               break;
           case R.id.homeId:
               fragment= new home();
               break;
           case R.id.searchId:
               fragment=new search();
               break;
           case R.id.favouriteId:
               fragment=new favorite();
               break;
           case R.id.notificationId:
               fragment=new notification();
               break;

       }
       return loadFragment(fragment);
    }
}