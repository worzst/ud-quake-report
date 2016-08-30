package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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

        // Find the TextViews for the magnitude, location, date and time
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);

        // Set the text for the magnitude
        magnitudeTextView.setText(currentEarthquake.getMagnitude());

        // Set the text for the location
        locationTextView.setText(currentEarthquake.getLocation());

        // Create a Date object from the time
        Date date = new Date(currentEarthquake.getTimeInMilliseconds());

        // Format the date
        String dateToDisplay = formatDate(date);
        // Set the text for the date
        dateTextView.setText(dateToDisplay);

        // Format the time
        String timeToDisplay = formatTime(date);
        // Set the text for the date
        timeTextView.setText(timeToDisplay);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());
        return timeFormat.format(dateObject);
    }
}
