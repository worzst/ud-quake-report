package com.example.android.quakereport;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by worzst on 29/08/16.
 * This class is used to make earthquake objects, which each represent 1 earthquake
 */
public class Earthquake {

    /** The magnitude of the earthquake */
    private String mMagnitude;

    /** String of the location where the earthquake happened */
    private String mLocation;

    /** The date when the earthquake happened */
    private String mDate;

    /**
     * Constructor to create an earthquake object
     * @param magnitude is the magnitude of the earthquake
     * @param location  is the location of the earthquake
     * @param date      is the date of when the earthquake happened
     */
    public Earthquake (String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /**
     * @return the magnitude of the earthquake
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return the location of the earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return the date of the earthquake
     */
    public String getDate() {
        return mDate;
    }
}