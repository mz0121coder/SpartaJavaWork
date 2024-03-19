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
    @DisplayName("String with numbers only")
    public void testNumbersAndSymbolsOnly() {
        List<String> testData = NumberWordUtils.longWordList("2939");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("String with numbers, symbols and spaces")
    public void testNumbersSymbolsAndSpaces() {
        List<String> testData = NumberWordUtils.longWordList("2939!@£  ");
        Assertions.assertTrue(testData.isEmpty());
    }

    @Test
    @DisplayName("Words all under 5 letters")
    public void testStringWithWordsALlUnder5Letters() {
        List<String> testData = NumberWordUtils.longWordList("mini word only less than five .£$@Q");
        Assertions.assertTrue(testData.isEmpty());
    }
    
}
