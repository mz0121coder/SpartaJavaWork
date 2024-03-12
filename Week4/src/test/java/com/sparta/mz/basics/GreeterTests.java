package com.sparta.mz.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GreeterTests {
    @Test
    @DisplayName("when time is -1, return 'Invalid time!'")
    void checkLowTime(){
        int timeTooLow = -1;
        String expected = "Invalid time!";
        String actual = Greeter.getGreeting(timeTooLow);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 0, return 'It's early'")
    void checkEarly0() {
        int time = 0;
        String expected = "It's early!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 4, return 'It's early!'")
    void checkEarly4() {
        int time = 4;
        String expected = "It's early!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 5, return 'Good morning!'")
    void checkMorning5() {
        int time = 5;
        String expected = "Good morning!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 11, return 'Good morning!'")
    void checkMorning11() {
        int time = 11;
        String expected = "Good morning!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 12, return 'Good afternoon!'")
    void checkAfternoon12() {
        int time = 12;
        String expected = "Good afternoon!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 17, return 'Good afternoon!'")
    void checkAfternoon() {
        int time = 17;
        String expected = "Good afternoon!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 18, return 'Good evening!'")
    void checkEvening18() {
        int time = 18;
        String expected = "Good evening!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 24, return 'Good evening!'")
    void checkEvening24() {
        int time = 24;
        String expected = "Good evening!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when time is 25, return 'Invalid time!'")
    void checkHighTime() {
        int timeTooHigh = 25;
        String actual = Greeter.getGreeting(timeTooHigh);
        Assertions.assertEquals("Invalid time!", actual);
    }

    @Test
    @DisplayName("when time is 21, return 'Good evening!'")
    void checkThat21ReturnsGoodEvening() {
        int time = 21;
        String expected = "Good evening!";
        String actual = Greeter.getGreeting(time);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 17})
    @DisplayName("when using 12 and 17, return 'Good afternoon!'")
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