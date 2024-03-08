package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

        cityList.add(city1);
        cityList.add(city2);

        assertTrue(cityList.hasCity(city1)); // City1 should be in the list
        assertTrue(cityList.hasCity(city2)); // City2 should be in the list
        assertFalse(cityList.hasCity(new City("Chicago", "Illinois"))); // City not in the list
    }

}
