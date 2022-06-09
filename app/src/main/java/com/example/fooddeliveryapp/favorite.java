package com.example.fooddeliveryapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favorite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favorite extends Fragment {
    // RatingBar ratingBar;
    //float myRating=0;
    //ListView list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public favorite() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favorite.
     */
    // TODO: Rename and change types and number of parameters
    public static favorite newInstance(String param1, String param2) {
        favorite fragment = new favorite();
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

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        RecyclerView recyclerViewOne = view.findViewById(R.id.favoriteIds);
        favoriteAdapter favOne = new favoriteAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewOne.setLayoutManager(linearLayoutManager);
        recyclerViewOne.setAdapter(favOne);
        favOne.setData(getFavoriteItems());
        // ratingBar=(RatingBar)getView().findViewById(R.id.ratingId);
       /* NotificationManager notificationManager=(NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
       int icon= R.drawable.bvg5;
       CharSequence text="item added to favorites";
       long when= System.currentTimeMillis();
       Context context= getActivity();
       CharSequence contextTitle="food delivery";
       CharSequence= contextText="to favorites";
       Intent notificationIntent= new Intent();
       PendingIntent contentIntent= PendingIntent.getActivity(getActivity(),0,notificationIntent,0);
       Notification notification= new Notification(icon,text,when);
       notification.setLatestEventInfo(context, contextTitle, contextText,contentIntent);
       notificationManager.notify(1, notification);*/


        return view;
    }

    private List<favoriteitems> getFavoriteItems() {
        List<favoriteitems> listFavorite = new ArrayList<favoriteitems>();
        listFavorite.add(new favoriteitems("bvg1", R.drawable.bvg1));
        listFavorite.add(new favoriteitems("bvg2", R.drawable.bvg2));
        listFavorite.add(new favoriteitems("bvg3", R.drawable.bvg3));
        listFavorite.add(new favoriteitems("bvg4", R.drawable.bvg4));
        listFavorite.add(new favoriteitems("bvg5", R.drawable.bvg5));
        return listFavorite;
    }

    /*public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
        int rating=(int) v;
        String message= null;
        myRating= ratingBar.getRating();
        switch(rating){
            case 1:
                message="below expectations!";
                break;
            case 2:
                message="average";
                break;
            case 3:
                message="Good";
                break;
            case 4:
                message="Great";
                break;
            case 5:
                message=" Wow Excellent!";
                break;

        }
    }*/
}