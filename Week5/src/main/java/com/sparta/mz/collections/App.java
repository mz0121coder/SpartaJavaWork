package com.sparta.mz.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
//        Array
        int[] intArray = {4, 8, 11, 16, 20};

        System.out.println("integer array: " + Arrays.toString(intArray));
        intArray[2] = 12;
        System.out.println("Updated integer array: " + Arrays.toString(intArray));

//        ArrayList
        ArrayList<String> names = new ArrayList<String>();
        names.add("Alex");
        names.add("Jack");
        names.add("X");
        names.add("Eve");
        names.add("Adam");

        System.out.println("Names: " + names);
        names.set(2, "Siyu");
        System.out.println("Updated names: " + names);

//        HashMap
        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 31);
        months.put("February", 28);
        months.put("March", 31);
        months.put("April", 30);
        months.put("May", 31);
        months.put("June", 30);
        months.put("July", 31);
        months.put("August", 31);
        months.put("September", 30);
        months.put("October", 31);
        months.put("November", 30);
        months.put("December", 31);

        System.out.println("February: " + months.get("February"));
        months.put("February", 29);
        System.out.println("February: " + months.get("February"));
    }
}
