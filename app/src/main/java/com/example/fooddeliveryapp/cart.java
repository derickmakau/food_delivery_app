package com.example.fooddeliveryapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseHelper myDb;
    EditText nameEditText;

    public cart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cart.
     */
    // TODO: Rename and change types and number of parameters
    public static cart newInstance(String param1, String param2) {
        cart fragment = new cart();
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
            myDb= new DatabaseHelper(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int num1, num2;

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        /*EditText editTextPrice=view.findViewById(R.id.priceId);
        EditText editTextQuantity=view.findViewById(R.id.quantityId);
        TextView totals= view.findViewById(R.id.totalsId);
                String price=editTextPrice.getText().toString();
        String quantity=editTextQuantity.getText().toString();
        num1=Integer.parseInt(price);
        num2=Integer.parseInt(quantity);
            int total =num1 * num2;
            totals.setText(Double.toString(total));*/
            //java.lang.NumberFormatException: For input string: ""



       /* nameEditText=(EditText)view.findViewById(R.id.itemNameId);
        Cursor res= myDb.getAllData();
        if(res.getCount()==0){
            Toast.makeText(getContext(),"nothing found",Toast.LENGTH_SHORT).show();
        }
        else{
            StringBuffer buffer= new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Id:"+ res.getString(0)+"\n");
                buffer.append("Name:"+res.getString(1)+"\n");
            }
            nameEditText.setText(buffer.toString());

        }*/
return view;
    }
}