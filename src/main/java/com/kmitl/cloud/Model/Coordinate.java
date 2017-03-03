package com.kmitl.cloud.Model;

/**
 * Created by snow_ on 04-Mar-17.
 */
public class Coordinate {
    private double Latitude;
    private double Longitude;

    public Coordinate() {
    }

    public Coordinate(double latitude, double longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
