package com.sparta.mz.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberWordUtils {
    public static HashSet<Integer> makeFiveSet(int max) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int i = 5; i <= max; i += 5) {
            integerHashSet.add(i);
        }
        return integerHashSet;
    }

    public static List<String> longWordList(String sentence) {
        String[] words = sentence.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            int lettersCount = word.replaceAll("[^a-zA-Z]+", "").length();
            if (lettersCount >= 5) result.add(word);
        }
        return result;
    }
}
