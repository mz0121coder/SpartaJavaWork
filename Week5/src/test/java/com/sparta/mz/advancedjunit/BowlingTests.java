package com.sparta.mz.advancedjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BowlingTests {

    @Test
    @DisplayName("All misses - 0 points")
    public void checkAllMissesReturnZeroPoints() {
        Assertions.assertEquals(0, Bowling.getTotalScore("-- -- -- -- -- -- -- -- -- --"));
    }

    @Test
    @DisplayName("All 9s - 90 points")
    public void checkAllNinesReturnNinetyPoints() {
        Assertions.assertEquals(90, Bowling.getTotalScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
    }

    @Test
    @DisplayName("All spares with final 5 - 150 points")
    public void checkAllSparesWithFinalFiveReturnOneHundredFiftyPoints() {
        Assertions.assertEquals(150, Bowling.getTotalScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
    }

    @Test
    @DisplayName("All strikes with bonus balls - 300 points")
    public void checkAllStrikesWithBonusBallsReturnThreeHundredPoints() {
        Assertions.assertEquals(300, Bowling.getTotalScore("X X X X X X X X X X X X"));
    }

    @Test
    @DisplayName("Mix of strikes, spares, and open frames - 167 points")
    public void checkMixedScoresReturnOneHundredSixtySevenPoints() {
        Assertions.assertEquals(167, Bowling.getTotalScore("X 9/ 5- 72 X X 9- X 2/ 3-"));
    }
}
