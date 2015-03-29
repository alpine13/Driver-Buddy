package com.driverbuddy.costeiu.driverbuddy.database.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

/**
 * Created by Costeiu on 3/19/2015.
 */
@ParseClassName("test")
public class PositionItem extends ParseObject {

    public PositionItem(){
        super();
    }


    public String getAddress() {
        return getString("Address");
    }

    public void setAddress(String address) {
        put("Address", address);
    }

    public String getCountry() {
        return getString("Country");
    }

    public void setCountry(String country) {
        put("Country", country);
    }

    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        put("Name", name);
    }

    public ParseGeoPoint getLocation(){
        return getParseGeoPoint("Location");
    }

    public void setLocation(ParseGeoPoint location){
        put("Location", location);
    }


}


