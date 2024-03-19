package com.sparta.mz.collections;

import java.util.HashMap;

public class LetterCounter {
    public static void counter(String message){
        String letters = message .replaceAll("\\s+","")
                .toLowerCase();
        HashMap<Character, Integer> lettersCount = new HashMap<>();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                lettersCount.put(c, lettersCount.getOrDefault(c, 0) + 1);
            }
        }

        for (char key : lettersCount.keySet()) {
            System.out.println(key + "=" + lettersCount.get(key));
        }
    }
}