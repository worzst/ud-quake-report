package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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

    private static final String LOCATION_SEPARATOR = " of ";

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
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);

        // Format the magnitude and set the text
        magnitudeTextView.setText(formatMagnitude(currentEarthquake.getMagnitude()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Split the location string into locationOffset and primaryLocation
        String[] loc = splitLocationString(currentEarthquake.getLocation());
        // Set the text for the location views
        locationOffsetTextView.setText(loc[0]);
        primaryLocationTextView.setText(loc[1]);

        // Create a Date object from the time
        Date date = new Date(currentEarthquake.getTimeInMilliseconds());

        // Format the date
        String formattedDate = formatDate(date);
        // Set the text for the date
        dateTextView.setText(formattedDate);

        // Format the time
        String formattedTime = formatTime(date);
        // Set the text for the date
        timeTextView.setText(formattedTime);

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

    /**
     * Return the formatted magnitude as string (i.e. "4.6") from a double magnitude value
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(magnitude);
    }

    /**
     *
     * @param magnitude magnitude of the earthquake
     * @return the color for the magnitude circle based on the intensity of the earthquake.
     */
    private int getMagnitudeColor(double magnitude) {
        int magFloor = (int) Math.floor(magnitude);
        switch (magFloor) {
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }

    /**
     * @param location is the complete location string
     * @return an array of 2 strings, where index 0 is the locationOffset and index 1 is the primaryLocation
     */
    private String[] splitLocationString(String location) {
        String[] locationParts = new String[2];
        if (location.contains(LOCATION_SEPARATOR)) {
            int index = location.indexOf(LOCATION_SEPARATOR) + 4;
            locationParts[0] = location.substring(0, index);
            locationParts[1] = location.substring(index);
        } else {
            locationParts[0] = getContext().getString(R.string.near_the);
            locationParts[1] = location;
        }
        return locationParts;
    }
}
