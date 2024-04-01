package com.sparta.mz.functionalprogramming;

public class ContainsAllAlphabet {
    public static void main(String[] args) {
        System.out.println(containsAllAlphabet("The quick brown fox jumps over the lazy dog"));
    }

    public static boolean containsAllAlphabet(String sentence) {
        return sentence
                .toLowerCase()
                .chars()
                .filter(letter -> letter >= 'a' && letter <= 'z')
                .distinct()
                .count() == 26;
    }
}
