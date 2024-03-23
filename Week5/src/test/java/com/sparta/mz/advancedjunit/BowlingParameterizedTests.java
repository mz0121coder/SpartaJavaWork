package com.sparta.mz.advancedjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BowlingParameterizedTests {

    @ParameterizedTest
    @CsvSource({
            "-- -- -- -- -- -- -- -- -- --, 0",
            "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-, 90",
            "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5, 150",
            "X X X X X X X X X X X X X, 300",
            "X 9/ 5- 72 X X 9- X 2/ 3-, 142",
    })

    @DisplayName("Test bowling scores")
    public void testBowlingScores(String game, int expectedScore) {
        Assertions.assertEquals(expectedScore, Bowling.getTotalScore(game));
    }
}
