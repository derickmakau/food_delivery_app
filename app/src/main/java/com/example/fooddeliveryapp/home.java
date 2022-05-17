package com.example.fooddeliveryapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
        rcvCategory.addOnItemTouchListener(new  RecyclerItemClickListener(getContext(),rcvCategory, new RecyclerItemClickListener.OnItemClickListener(){
@Override
            public void onItemClick(View view, int position){
    Toast.makeText(getContext(),"done... click", Toast.LENGTH_SHORT).show();
    //do whatever;
}
public void onLongItemClick(View view, int position){
    Toast.makeText(getContext(),"wow... long click",Toast.LENGTH_SHORT).show();

}
        }));
        return view;
    }
    @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

    }
    private List<Category> getListCategory(){
        List<Category> listCategory=new ArrayList<Category>();
        List<Food> listFood=new ArrayList<Food>();
        listFood.add(new Food(R.drawable.beverageone,"lemon water"));
        listFood.add(new Food(R.drawable.beveragetwo,"red wine"));
        listFood.add(new Food(R.drawable.beveragethree,"german coffee"));
        listFood.add(new Food(R.drawable.breakfastone,"tea"));
        listFood.add(new Food(R.drawable.breakfasttwo,"lemon tea"));
        listFood.add(new Food(R.drawable.breakfastthree,"japan drink"));
        listFood.add(new Food(R.drawable.breakfastfour,"toast"));
        listFood.add(new Food(R.drawable.lunchone,"half burger"));

        listCategory.add(new Category("our breakfast",listFood));
        listCategory.add(new Category("lunch",listFood));
        listCategory.add(new Category("beverages",listFood));
        listCategory.add(new Category("dinner",listFood));
        return listCategory;
    }

}