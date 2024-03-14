package com.sparta.mz.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringExercises_Tests {
    @ParameterizedTest
    @CsvSource({
            " Cathy, 10, CATHY0123456789",
            "'', 4, 0123",
            " Piano , 12, PIANO01234567891011"
    })
    public void givenAString_ManipulateStringUsingStringBuilder_ReturnsATransformedString(String original, int num, String expected) {
        Assertions.assertEquals(expected, StringExercises.manipulateStringUsingStringBuilder(original, num));
    }

    @Test
    public void address_GivenItsComponents_ReturnsAFormattedAddressString() {
        String result = StringExercises.address(5, "Main Street", "Stone", "ST6 2RQ");
        String expAddress = "5 Main Street, Stone ST6 2RQ.";
        Assertions.assertEquals(expAddress, result);
    }

    @ParameterizedTest
    @CsvSource({
            "33, 40, You got 33 out of 40: 82.5%",
            "18, 65, You got 18 out of 65: 27.7%"
    })
    public void givenATestScore_Scorer_ReturnsAFormattedString(int score, int outOf, String expString) {
        String result = StringExercises.scorer(score, outOf);
        Assertions.assertEquals(expString, result);
    }
}
