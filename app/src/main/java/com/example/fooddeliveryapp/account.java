package com.example.fooddeliveryapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link account#newInstance} factory method to
 * create an instance of this fragment.
 */
public class account extends Fragment {
    private int REQUEST_PICK_IMAGE=1000;
    CircleImageView imageOne;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public account() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment search.
     */
    // TODO: Rename and change types and number of parameters
    public static account newInstance(String param1, String param2) {
        account fragment = new account();
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
        View view=inflater.inflate(R.layout.fragment_account, container, false);
        imageOne=(CircleImageView) view.findViewById(R.id.accountImage);
        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2000);
}
else{
    startGallery();
}
            }

            private void startGallery() {
                Intent cameraIntent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                cameraIntent.setType("image/*");
                if(cameraIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivityForResult(cameraIntent, 1000);
                }
            }
           /* @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                //super.onActivityResult(requestCode, resultCode, data);
                //super method removed
                if(resultCode == RESULT_OK) {
                    if(requestCode == 1000){
                        Uri returnUri = data.getData();
                        Bitmap bitmapImage = null;
                        try {
                            bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageOne.setImageBitmap(bitmapImage);
                    }
                }}*/

          /*  private void onPickImage() {
                Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_PICK_IMAGE);
            }
            //@Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
               // super.onActivityResult(requestCode, resultCode, data);
                if(resultCode== RESULT_OK){
                    if(requestCode== REQUEST_PICK_IMAGE){
                        Uri uri= data.getData();
                        Bitmap bitmap= loadFromUri(uri);
                        imageOne.setImageBitmap(bitmap);

                    }
                }
            }
            private Bitmap loadFromUri(Uri uri){
                Bitmap bitmap= null;
                try{
                    if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1){
                        ImageDecoder.Source source = ImageDecoder.createSource(getActivity().getContentResolver(),uri);
                        bitmap= ImageDecoder.decodeBitmap(source);
                    }
                    else{
                        bitmap= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uri);
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                return bitmap;
            }*/
        });
        return view;
    }
}