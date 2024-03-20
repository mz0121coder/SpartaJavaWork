package com.sparta.mz.hamcrest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTests {
    @Test
    void given2And6_Add_Returns8Pt0() {
        Calculator calc = new Calculator(6, 2);
        assertThat(calc.add(), is(8.0));
    }

    @Test
    void given6And3_DivisibleBy_ReturnsTrue() {
        Calculator calc = new Calculator(6, 2);
        assertThat(calc.divisibleBy(), is(true));
    }

    @Test
    void given7And3_DivisibleBy_ReturnsFalse() {
        Calculator calc = new Calculator(7, 3);
        assertThat(calc.divisibleBy(), is(false));
    }

    @Test
    void given7And3_ToString_OutputContainsCalculator() {
        Calculator calc = new Calculator(7, 3);
        assertThat(calc.toString(), containsString("Calculator"));
    }

    @Test
    void given2And7_Add_Returns9Pt0() {
        Calculator calc = new Calculator(2, 7);
        assertThat(calc.add(), is(9.0));
    }

    @Test
    void collectionMatchersExercise() {
        List<String> fruit = List.of(
                "apple", "pear", "banana", "peach", "pomegranate", "pineapple", "lemon");
        assertThat(
                fruit,
                containsInRelativeOrder("apple", "banana", "pomegranate", "lemon"));
        assertThat(fruit, hasItems("banana", "pomegranate"));
        assertThat(fruit, not(hasItem("grape")));
    }
}
