package com.sparta.mz.collections;

import java.util.*;

public class Examples {
    public static void main(String[] args) {
        //        Array
        int[] intArray = {4, 8, 11, 16, 20};

        System.out.println("integer array: " + Arrays.toString(intArray));
        intArray[2] = 12;
        System.out.println("Updated integer array: " + Arrays.toString(intArray));

//        ArrayList
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Alex");
        namesList.add("Jack");
        namesList.add("X");
        namesList.add("Eve");
        namesList.add("Adam");

        System.out.println("Names: " + namesList);
        namesList.set(2, "Siyu");
        System.out.println("Updated names: " + namesList);

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

//        Hash Set
        HashSet<String> names = new HashSet<>(List.of("Terry", "Karen", "Fred", "Jimmy", "Brenda"));

        HashSet<String> moreNames = new HashSet<>(List.of("Carol", "Brenda", "Jeffrey", "Albert", "Terry"));

        HashSet<String> allNames = new HashSet<>();

        allNames.addAll(names);
        allNames.addAll(moreNames);
        System.out.println(allNames);

        for(String name: names) {
            System.out.println(name);
        }

        names.add("Fred");
        System.out.println(names);
    }
}
