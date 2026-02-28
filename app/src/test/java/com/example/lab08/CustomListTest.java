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

        // The exception should throw out since city is not in cityList now
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(edmonton);
        });
    }
}