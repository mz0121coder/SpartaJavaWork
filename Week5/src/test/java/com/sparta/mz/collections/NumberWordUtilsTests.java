package com.sparta.mz.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class NumberWordUtilsTests {
    //    tests for makeFiveSet method
    @Test
    @DisplayName("Negative number - returns empty set")
    public void testNegativeInt() {
        int testDataSize = NumberWordUtils.makeFiveSet(-1).size();
        Assertions.assertEquals(testDataSize, 0);
    }

    @Test
    @DisplayName("Zero - returns empty set")
    public void testZero() {
        int testDataSize = NumberWordUtils.makeFiveSet(0).size();
        Assertions.assertEquals(testDataSize, 0);
    }

    @Test
    @DisplayName("Numbers between 0 and 5 - return empty set")
    public void testBetween0and5() {
        HashSet<Integer> testData1 = NumberWordUtils.makeFiveSet(1);
        HashSet<Integer> testData2 = NumberWordUtils.makeFiveSet(4);

        Assertions.assertEquals(0, testData1.size());
        Assertions.assertEquals(0, testData2.size());
    }

    @Test
    @DisplayName("5 - returns set containing just 5")
    public void test5() {
        HashSet<Integer> testData = NumberWordUtils.makeFiveSet(5);

        Assertions.assertTrue(testData.size() == 1 && testData.contains(5));
    }

    @Test
    @DisplayName("Max 31 - set only contains numbers divisible by 5, under max")
    public void testNumbersDivisibleBy5() {
        HashSet<Integer> testData = NumberWordUtils.makeFiveSet(31);
        int[] expected = {5, 10, 15, 20, 25, 30};
        for (int n : expected) {
            Assertions.assertTrue(testData.contains(n));
        }
    }

    @Test
    @DisplayName("Max 16 - set doesn't contain numbers not divisible by 5, under max")
    public void testNumbersNotDivisibleBy5() {
        HashSet<Integer> testData = NumberWordUtils.makeFiveSet(16);
        int[] notExpected = {-1, 0, 1, 4, 6, 9, 11, 14, 16};
        for (int n : notExpected) {
            Assertions.assertFalse(testData.contains(n));
        }
    }

    //    tests for longWordList method
    @Test
    @DisplayName("Empty string - returns empty list")
    public void testEmptyString() {
        List<String> testData = NumberWordUtils.longWordList("");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("String with spaces only - returns empty list")
    public void testSpacesOnly() {
        List<String> testData = NumberWordUtils.longWordList("     ");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("String with numbers only - returns empty list")
    public void testNumbersAndSymbolsOnly() {
        List<String> testData = NumberWordUtils.longWordList("2939");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("String with numbers, symbols and spaces - returns empty list")
    public void testNumbersSymbolsAndSpaces() {
        List<String> testData = NumberWordUtils.longWordList("2939!@£  ");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("Words all under 5 letters - returns empty list")
    public void testStringWithWordsAllUnder5Letters() {
        List<String> testData = NumberWordUtils.longWordList("mini word only less than five .£$@Q");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("Words all at least 5 letters - returns set with each word included")
    public void testStringWithWordsAllAtLeast5Letters() {
        List<String> testData = NumberWordUtils.longWordList("Elephant Giraffe Tiger Animals");
        String[] words = {"Elephant", "Giraffe", "Tiger", "Animals"};
        for (String w : words) Assertions.assertTrue(testData.contains(w));
        Assertions.assertEquals(testData.size(), words.length);
    }

    @Test
    @DisplayName("Mix of words under/over 5 letters - returns correct set")
    public void testStringWithMixedWords() {
        List<String> testData = NumberWordUtils.longWordList(("This is a mixed string of words, d1g1ts and s4mbo!$."));
        String[] words = {"mixed", "string", "words,"};
        System.out.println(testData);
        for (String w : words) Assertions.assertTrue(testData.contains(w));
        Assertions.assertEquals(3, testData.size());
    }
}
