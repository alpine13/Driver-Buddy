package com.driverbuddy.costeiu.driverbuddy.database.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Costeiu on 3/13/2015.
 */

@ParseClassName("GasStation")
public class GasStationItem extends ParseObject  implements ClusterItem{
    private LatLng mPosition;

    public GasStationItem(){
        super();
    }

    public GasStationItem(String lat, String lng){
        mPosition = new LatLng((Double.parseDouble(lat)), Double.parseDouble(lng));
    }
    public String getLatitude() {
        return getString("Latitude");
    }

    public void setLatitude(String latitude) {
        put("Latitude", latitude);
    }

    public String getLongitude() {
        return getString("Longitude");
    }

    public void setLongitude(String longitude) {
        put("Longitude", longitude);
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


    @Override
    public LatLng getPosition(){
        return mPosition;
    }

}
