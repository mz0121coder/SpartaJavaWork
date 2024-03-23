package com.sparta.mz.advancedjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BowlingTests {

    @Test
    @DisplayName("10 strikes - 300 points")
    public void checkTenStrikesReturnThreeHundredPoints() {
        Assertions.assertEquals(300, Bowling.getScore("X X X X X X X X X X X X"));
    }

    @Test
    @DisplayName("All 9s - 90 points")
    public void checkAllNinesReturnNinetyPoints() {
        Assertions.assertEquals(90, Bowling.getScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
    }

    @Test
    @DisplayName("All spares with final 5 - 150 points")
    public void checkAllSparesWithFinalFiveReturnOneHundredFiftyPoints() {
        Assertions.assertEquals(150, Bowling.getScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
    }

    @Test
    @DisplayName("All misses - 0 points")
    public void checkAllMissesReturnZeroPoints() {
        Assertions.assertEquals(0, Bowling.getScore("-- -- -- -- -- -- -- -- -- --"));
    }

    @Test
    @DisplayName("Mix of strikes, spares, and open frames - 167 points")
    public void checkMixedScoresReturnOneHundredSixtySevenPoints() {
        Assertions.assertEquals(167, Bowling.getScore("X 9/ 5- 72 X X 9- X 2/ 3-"));
    }

    @Test
    @DisplayName("All strikes with bonus balls - 300 points")
    public void checkAllStrikesWithBonusBallsReturnThreeHundredPoints() {
        Assertions.assertEquals(300, Bowling.getScore("X X X X X X X X X X X X X"));
    }
}
