package com.driverbuddy.costeiu.driverbuddy.slidingmenu.view;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.driverbuddy.costeiu.driverbuddy.database.model.GasStationItem;
import com.driverbuddy.costeiu.driverbuddy.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Costeiu on 3/9/2015.
 */
public class GasStationFragment extends Fragment {

    private static final String TAG = GasStationFragment.class.getSimpleName();
    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
        Log.d(TAG, this + ": onCreate()");
    }

    @Override
    public void onAttach(final Activity activity)
    {
        super.onAttach(activity);
        Log.d(TAG, this + ": onAttach(" + activity + ")");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, this + ": onActivityCreated()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.d(TAG, this + ": onCreateView()");
        View rootView = inflater.inflate(R.layout.fragment_gas_station, container, false);

        // setContentView(R.layout.map_layout);
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();
        addMarkers();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, this + ": onViewCreated()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, this + ": onDestroyView()");
        try {
            MapFragment fragment = (MapFragment) getActivity()
                    .getFragmentManager().findFragmentById(
                            R.id.map);
            if (fragment != null) getFragmentManager().beginTransaction().remove(fragment).commit();

        } catch (IllegalStateException e) {
        }
    }


    @Override
    public void onDetach()
    {
        super.onDetach();
        Log.d(TAG, this + ": onDetach()");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, this + ": onStart()");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG, this + ": onResume()");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG, this + ": onPause()");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG, this + ": onStop()");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, this + ": onDestroy()");
    }


    private void addMarkers(){

        ParseQuery<GasStationItem> query = ParseQuery.getQuery(GasStationItem.class);
        query.setLimit(1000);
        query.findInBackground(new FindCallback<GasStationItem>() {
            @Override
            public void done(List<GasStationItem> gasStationItems, ParseException e) {
                if (e == null) {

                    Log.d("THE OBJECT", "" + gasStationItems.size());

                    ArrayList<Marker> mMarkers = new ArrayList<Marker>();


                    for (int i=0; i< gasStationItems.size(); i++){
                        GasStationItem gasStationItem = gasStationItems.get(i);
                        LatLng latLng = new LatLng((Double.parseDouble(gasStationItem.getLatitude())), Double.parseDouble(gasStationItem.getLongitude()));

                        String gasStationName = gasStationItem.getName();
                        BitmapDescriptor bitmapMarker = customizeMarkers(gasStationName);

                        mMarkers.add(mMap.addMarker(new MarkerOptions().position(latLng)
                                .title("Hamburg")
                                .icon(bitmapMarker)));


                        // Move the camera instantly to hamburg with a zoom of 15.
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9));

                    }

                    // Zoom in, animating the camera
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

                } else {
                    Log.d("ERROR:", "" + e.getMessage());
                }
            }
        });
    }

    private BitmapDescriptor customizeMarkers(String input){

        BitmapDescriptor bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
        if(input.contains("Gazprom")){
            bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.gazprom);
        } else {
            if(input.contains("Mol")) {
                bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.mol);
            } else {
                if(input.contains("Petrom")){
                    bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.petrom);
                } else {
                    if(input.contains("OMV")){
                        bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.omv);
                    } else {
                        if(input.contains("Lukoil")){
                            bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.lukoil);
                        } else {
                            if(input.contains("Rompetrol")){
                                bitmapMarker = BitmapDescriptorFactory.fromResource(R.mipmap.rompetrol);
                            }
                        }
                    }
                }
            }
        }

        return bitmapMarker;
    }


    }

