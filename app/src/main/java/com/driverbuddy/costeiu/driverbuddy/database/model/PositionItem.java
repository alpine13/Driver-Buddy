package com.driverbuddy.costeiu.driverbuddy.database.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Costeiu on 3/19/2015.
 */
public class PositionItem implements ClusterItem {

    private final LatLng mPosition;

    public PositionItem(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
