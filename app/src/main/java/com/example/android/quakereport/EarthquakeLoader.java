package com.example.android.quakereport;

import java.util.List;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by worzst on 31/08/16.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader (Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakes(mUrl);
        return earthquakes;
    }
}
