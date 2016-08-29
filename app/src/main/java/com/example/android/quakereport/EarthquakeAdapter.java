package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by worzst on 29/08/16.
 * {@link EarthquakeAdapter} is an {@link ArrayAdapter} that provides the layout for each item in a
 * list of {@link Earthquake} objects
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    /**
     * Custom constructer for the {@link EarthquakeAdapter}
     * @param context       Is the current context, used to inflate the layout
     * @param earthquakes   A list of {@link Earthquake} objects to display in a list
     */
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Provides a view
     * @param position      The position of the item in the list
     * @param convertView   The recycled View to populate
     * @param parent        The parent ViewGroup, used for inflation
     * @return              The View for the position in the AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        // Get the Earthquake object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextViews for the magnitude, location and date
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        // Set the text for all the TextViews
        magnitudeTextView.setText(currentEarthquake.getMagnitude());
        locationTextView.setText(currentEarthquake.getLocation());
        dateTextView.setText(currentEarthquake.getDate());

        return listItemView;
    }
}
