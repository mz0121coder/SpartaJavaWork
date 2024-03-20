package com.sparta.mz.advancedjunit;

public class TDD {

    public static String getFizzBuzzValue(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;
        if (divisibleBy3 && !divisibleBy5) return "Fizz";
        if (!divisibleBy3 && divisibleBy5) return "Buzz";
        if (divisibleBy3 && divisibleBy5) return "FizzBuzz";
        return Integer.toString(number);
    }
}
