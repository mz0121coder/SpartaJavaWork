package com.sparta.mz.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilmClassificationTests {
    @Test
    @DisplayName("when age is -1, return 'Invalid age.'")
    void checkAgeInvalid() {
        int age = -1;
        String expected = "Invalid age.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 0, return 'U & PG films are available.'")
    void checkAge0() {
        int age = 0;
        String expected = "U & PG films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 11, return 'U & PG films are available.'")
    void checkAgeUnder12() {
        int age = 11;
        String expected = "U & PG films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 12, return 'U, PG & 12 films are available.'")
    void checkAge12() {
        int age = 12;
        String expected = "U, PG & 12 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 14, return 'U, PG & 12 films are available.'")
    void checkAgeUnder15() {
        int age = 14;
        String expected = "U, PG & 12 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 15, return 'U, PG, & 12 and 15 films are available.'")
    void checkAge15() {
        int age = 15;
        String expected = "U, PG, & 12 and 15 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 17, return 'U, PG, & 12 and 15 films are available.'")
    void checkAge16() {
        int age = 17;
        String expected = "U, PG, & 12 and 15 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("when age is 18, return 'All films are available.'")
    void checkAge18() {
        int age = 18;
        String expected = "All films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }
}
