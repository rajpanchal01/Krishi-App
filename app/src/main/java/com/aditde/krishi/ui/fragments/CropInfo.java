package com.aditde.krishi.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditde.krishi.R;
import com.aditde.krishi.ui.fragments.cropinfo.Cotton;
import com.aditde.krishi.ui.fragments.cropinfo.Maize;
import com.aditde.krishi.ui.fragments.cropinfo.Millet;
import com.aditde.krishi.ui.fragments.cropinfo.Mustard;
import com.aditde.krishi.ui.fragments.cropinfo.Rice;
import com.aditde.krishi.ui.fragments.cropinfo.Sugarcane;
import com.aditde.krishi.ui.fragments.cropinfo.Tea;
import com.aditde.krishi.ui.fragments.cropinfo.Wheat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CropInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CropInfo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CropInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CropInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static CropInfo newInstance(String param1, String param2) {
        CropInfo fragment = new CropInfo();
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
        return inflater.inflate(R.layout.fragment_crop_info, container, false);
    }

    /*public void rice(View view) {
        Intent intent = new Intent(getContext(), Rice.class);
        startActivity(intent);
    }

    public void wheat(View view) {
        Intent intent = new Intent(getContext(), Wheat.class);
        startActivity(intent);
    }

    public void maize(View view) {
        Intent intent = new Intent(getContext(), Maize.class);
        startActivity(intent);
    }

    public void cotton(View view) {
        Intent intent = new Intent(getContext(), Cotton.class);
        startActivity(intent);
    }

    public void sugarcane(View view) {
        Intent intent = new Intent(getContext(), Sugarcane.class);
        startActivity(intent);
    }

    public void millet(View view) {
        Intent intent = new Intent(getContext(), Millet.class);
        startActivity(intent);
    }

    public void tea(View view) {
        Intent intent = new Intent(getContext(), Tea.class);
        startActivity(intent);
    }

    public void mustard(View view) {
        Intent intent = new Intent(getContext(), Mustard.class);
        startActivity(intent);
    }*/
}
