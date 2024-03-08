package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * Returns the number of cities in the list.
     *
     * @return The number of cities in the list.
     */
    public int getCount(){
//      return cities.size();
        return 0;
    }

    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Checks if a city is present in the list.
     *
     * @param city1 The city to check for.
     * @return True if the city is in the list, false otherwise.
     */
    public boolean hasCity(City city1) {
        return cities.contains(city1);
    }

    /**
     * Removes a city from the list if it exists. Otherwise, throws an exception.
     *
     * @param city The city to remove.
     * @throws IllegalArgumentException If the city is not in the list.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list.");
        }
        cities.remove(city);
    }
}
