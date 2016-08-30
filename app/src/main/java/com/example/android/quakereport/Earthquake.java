package com.example.android.quakereport;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by worzst on 29/08/16.
 * This class is used to make earthquake objects, which each represent 1 earthquake
 */
public class Earthquake {

    /** The magnitude of the earthquake */
    private double mMagnitude;

    /** String of the location where the earthquake happened */
    private String mLocation;

    /** The date when the earthquake happened */
    private long mTimeInMilliseconds;

    /** The url that leads to the usgv website with the earthquake details */
    private String mUrl;

    /**
     * Constructor to create an earthquake object
     * @param magnitude             is the magnitude of the earthquake
     * @param location              is the location of the earthquake
     * @param timeInMilliseconds    is the time of when the earthquake happened
     * @param url                   is the url which leads to the detailed website of the earthquake
     */
    public Earthquake (double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * @return the magnitude of the earthquake
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return the location of the earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return the time of the earthquake
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * @return the url that leads to the usgv website with the earthquake details
     */
    public String getUrl() {
        return mUrl;
    }
}
