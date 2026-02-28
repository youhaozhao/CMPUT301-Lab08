package com.example.lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDeleteCity() {
        CustomList list = new CustomList();
        City edmonton = new City("Edmonton", "AB");
        list.addCity(edmonton);

        // Ensure Edmonton is in list
        assertTrue(list.hasCity(edmonton));

        // Delete Edmonton from the list
        list.deleteCity(edmonton);
        assertFalse(list.hasCity(edmonton));

        // The exception should throw out since city is not in list now
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(edmonton);
        });
    }

    @Test
    public void testCountCities() {
        CustomList list = new CustomList();

        // Now list is empty, countCities should return 0
        assertEquals(0, list.countCities());

        // Add City 1, countCities should return 1
        City city1 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city1);
        assertEquals(1, list.countCities());

        // Add City 2, countCities should return 2
        City city2 = new City("Yellowknife", "Northwest Territories");
        list.addCity(city2);
        assertEquals(2, list.countCities());

        // Delete City 2, countCities should return 1
        list.deleteCity(city2);
        assertEquals(1, list.countCities());
    }
}