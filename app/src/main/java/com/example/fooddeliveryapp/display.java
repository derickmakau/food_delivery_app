package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.LayoutTransition;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class display extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
BottomNavigationView navigationView;
LinearLayout layoutCart;
LinearLayout layoutLike;
LinearLayout layout;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        loadFragment(new home());
        toolbar=(Toolbar)findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.bottomNavigationViewId);
        layoutCart=(LinearLayout)findViewById(R.id.hideCartId);
        layoutLike=(LinearLayout)findViewById(R.id.hideLikeId);
        layout=(LinearLayout)findViewById(R.id.layoutId);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

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
               break;
           case R.id.search:
               Intent intentOne= new Intent(display.this,searchActivity.class);
               startActivity(intentOne);
               break;

       }
       return super.onOptionsItemSelected(item);

   }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       Fragment fragment=null;
       switch(item.getItemId()){
           case R.id.homeId:
               fragment= new home();
               break;
           case R.id.searchId:
               fragment=new account();
               break;
           case R.id.cartId:
               fragment = new cart();
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