package com.driverbuddy.costeiu.driverbuddy.slidingmenu.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.driverbuddy.costeiu.driverbuddy.R;

/**
 * Created by Costeiu on 3/9/2015.
 */
public class MyCarFragment extends Fragment {

    public MyCarFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_my_car, container, false);

        return rootView;
    }
}
