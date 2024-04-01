package com.sparta.mz.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class VowelMatcher {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("John", "Paul", "George", "Ringo", "Jonathan", "George", "Paul", "Richard", "Freddie", "Brian", "Rodger", "John", "Brian", "James", "DJ"));
        names.stream()
                .distinct()
                .filter(name -> countVowels(name) == 2)
                .forEach(System.out::println);
    }

    private static int countVowels(String name) {
        int vowelCount = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.toLowerCase().charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCount++;
        }
        return vowelCount;
    }
}
