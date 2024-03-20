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
}
