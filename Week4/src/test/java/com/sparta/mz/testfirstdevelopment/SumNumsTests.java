package com.sparta.mz.testfirstdevelopment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumNumsTests {

    @Test
    @DisplayName("Given start and end, sumNums returns the sum from start to end")
    public void givenTwoNumbers_SumNums_ReturnsTheSumFromStartToEnd() {
        int result = Methods.sumNums(3, 6);
        Assertions.assertEquals(18, result);
    }


    @Test
    @DisplayName("Given two equal numbers, sumNums returns the number")
    public void givenTwoEqualNumbers_SumNums_ReturnsTheNumber() {
        int result = Methods.sumNums(3, 3);
        Assertions.assertEquals(3, result);
    }

    @Test
    @DisplayName("Given two negative numbers, sumNums returns the sum from start to end")
    public void givenTwoNegativeNumbers_SumNums_ReturnsTheSumFromStartToEnd() {
        int result = Methods.sumNums(-3, -1);
        Assertions.assertEquals(-6, result);
    }

    @Test
    @DisplayName("Given two large positive numbers, sumNums returns the sum from start to end")
    public void givenTwoLargePositiveNumbers_SumNums_ReturnsTheSumFromStartToEnd() {
        int result = Methods.sumNums(100, 200);
        Assertions.assertEquals(15150, result);
    }

    @Test
    @DisplayName("Given two numbers where the start is larger, sumNums returns the correct sum")
    public void givenTwoNumbersStartLarger_SumNums_ReturnsTheCorrectSum() {
        int result = Methods.sumNums(10, 6);
        Assertions.assertEquals(40, result);
    }

    @Test
    @DisplayName("Given two edge case numbers, sumNums returns the sum from start to end")
    public void givenEdgeCaseNumbers_SumNums_ReturnsTheSumFromStartToEnd() {
        int result = Methods.sumNums(0, -1);
        Assertions.assertEquals(-1, result);
    }
}