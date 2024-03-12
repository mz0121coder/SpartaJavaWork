package com.sparta.mz.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GreeterTests {
    @Test
    @DisplayName("when time is 21, return good evening")
    void checkThat21ReturnsGoodEvening() {
        int time = 21;
        String expected = "Good evening!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("check early morning hours")
    void checkThat4ReturnsGoodMorning() {
        int time = 4;
        String expected = "It's early!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("check invalid time")
    void checkInvalidTime() {
        int invalidTime = 49;
        String actual = Greeter.getGreeting(invalidTime);
        Assertions.assertEquals("Good evening!", actual);
    }

    @Test
    @DisplayName("check 3pm returns afternoon message")
    void checkAfternoon() {
        int time = 15;
        String expected = "Good afternoon!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 18})
    @DisplayName("when using 12 and 18, return good afternoon")
    void check12And18ReturnsGoodAfternoon(int time) {
        Assertions.assertEquals("Good afternoon!", Greeter.getGreeting(time));
    }

    @ParameterizedTest
    @DisplayName("check that the correct greeting is returned")
    @CsvSource({
            "It's early!, 2",
            "Good morning!, 8",
            "Good afternoon!, 15",
            "Good evening!, 21"
    })
    void checkThatCorrectGreetingIsReturned(String greeting, int time) {
        Assertions.assertEquals(greeting, Greeter.getGreeting(time));
    }
}