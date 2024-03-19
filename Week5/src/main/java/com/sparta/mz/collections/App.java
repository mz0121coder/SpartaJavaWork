package com.sparta.mz.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Leonardo", "Donatello", "Michael", "Raphael"));
        Collections.sort(names);
        System.out.println(names);

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Manish", "Gadhvi"));
        people.add(new Person("Alex", "Blunt"));
        people.add(new Person("Joe", "Bloggs"));
        people.add(new Person("David", "Harvey"));

        Collections.sort(people, new PersonComparator());
        System.out.println(people);

        System.out.println(NumberWordUtils.makeFiveSet(16));
        System.out.println(NumberWordUtils.longWordList("Words greater seven"));
    }
}
