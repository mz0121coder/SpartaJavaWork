package com.sparta.mz.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionalPractice {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("John", "Paul", "George", "Ringo"));
        names.stream()
                .filter(name -> name.contains("o"))
                .map(String::toUpperCase) //name -> name.toLowerCase()
                .forEach(System.out::println);
    }
}
