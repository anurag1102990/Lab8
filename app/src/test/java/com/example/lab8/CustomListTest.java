package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        CustomList cityList = new CustomList(null, new ArrayList<>());
        City city1 = new City("New York", "New York");
        City city2 = new City("Los Angeles", "California");

        cityList.addCity(city1);
        cityList.addCity(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list
        assertTrue(cityList.hasCity(city2)); // City2 should be in the list
        assertFalse(cityList.hasCity(new City("Chicago", "Illinois"))); // City not in the list
    }

    @Test
    public void testDelete() {
        CustomList cityList = new CustomList(null, new ArrayList<>());
        City city1 = new City("San Francisco", "California");
        City city2 = new City("Seattle", "Washington");

        cityList.addCity(city1);
        cityList.addCity(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list

        // Delete city1
        cityList.delete(city1);

        assertFalse(cityList.hasCity(city1)); // City1 should no longer be in the list
        assertEquals(1, cityList.getCount()); // There should be only 1 city left

        // Try to delete city1 again, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });

        // Try to delete a city not in the list, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Chicago", "Illinois"));
        });
    }

}
