package com.example.fooddeliveryapp;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rcvCategory=view.findViewById(R.id.new_category);
        CategoryAdapter categoryAdapter=new CategoryAdapter(this.getContext(),getListCategory());/*check for error here if it doesn't work*/
        /* check whether this adapter is suppossed to be present.*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        return view;
    }
    @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

    }
    private List<Category> getListCategory(){
        List<Category> listCategory=new ArrayList<Category>();
        List<Food> listFood=new ArrayList<Food>();
        listFood.add(new Food(R.drawable.bvg1,"bvg1",false));
        listFood.add(new Food(R.drawable.bvg2,"bvg2",false));
        listFood.add(new Food(R.drawable.bvg3,"bvg3",false));
        listFood.add(new Food(R.drawable.bvg4,"bvg4",false));
        listFood.add(new Food(R.drawable.bvg5,"bvg5",false));
        listFood.add(new Food(R.drawable.bvg6,"bvg6",false));
        listFood.add(new Food(R.drawable.bvg7,"bvg7",false));
        listFood.add(new Food(R.drawable.bvg8,"bvg8",false));
        List<Food> listFoodTwo= new ArrayList<Food>();
        listFoodTwo.add(new Food(R.drawable.frts1,"frts1",false));
        listFoodTwo.add(new Food(R.drawable.frts2,"frts2",false));
        listFoodTwo.add(new Food(R.drawable.frts3,"frts3",false));
        listFoodTwo.add(new Food(R.drawable.frts4,"frts4",false));
        listFoodTwo.add(new Food(R.drawable.frts5,"frts5",false));
        listFoodTwo.add(new Food(R.drawable.frts6,"frts6",false));
        List<Food> listFoodThree= new ArrayList<Food>();
        listFoodThree.add(new Food(R.drawable.lnch1,"lnch1",false));
        listFoodThree.add(new Food(R.drawable.lnch2,"lnch2",false));
        listFoodThree.add(new Food(R.drawable.lnch3,"lnch3",false));
        listFoodThree.add(new Food(R.drawable.lnch4,"lnch4",false));
        listFoodThree.add(new Food(R.drawable.lnch5,"lnch5",false));
        listFoodThree.add(new Food(R.drawable.lunchsix,"lnch6",false));
        listFoodThree.add(new Food(R.drawable.lnch7,"lnch7",false));
        List<Food> listFoodFour= new ArrayList<Food>();
        listFoodFour.add(new Food(R.drawable.sf1,"sf1",false));
        listFoodFour.add(new Food(R.drawable.sf2,"sf2",false));
        listFoodFour.add(new Food(R.drawable.sf3,"sf3",false));
       listFoodFour.add(new Food(R.drawable.sf4,"sf4",false));
       listFoodFour.add(new Food(R.drawable.sf5,"sf5",false));
        listFoodFour.add(new Food(R.drawable.sf6,"sf6",false));

        listCategory.add(new Category("beverage",listFood));
        listCategory.add(new Category("fruits",listFoodTwo));
        listCategory.add(new Category("lunch",listFoodThree));
        listCategory.add(new Category("seafood",listFoodFour));
        return listCategory;
    }

}