package com.sparta.mz.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilmClassificationTests {
    @Test
    @DisplayName("handles invalid age")
    void checkAgeInvalid() {
        int age = -1;
        String expected = "Invalid age.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks a user under 12")
    void checkAgeUnder12() {
        int age = 11;
        String expected = "U & PG films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks a user with age of 12")
    void checkAge12() {
        int age = 12;
        String expected = "U, PG & 12 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks a user with age over 12 and under 15")
    void checkAgeUnder15() {
        int age = 13;
        String expected = "U, PG & 12 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks a user with age of 15")
    void checkAge15() {
        int age = 15;
        String expected = "U, PG, & 12 and 15 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks a user with age above 15 and less than 18")
    void checkAge16() {
        int age = 16;
        String expected = "U, PG, & 12 and 15 films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks a user with age of 18")
    void checkAge18() {
        int age = 18;
        String expected = "All films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("checks a user with age above 18")
    void checkAgeAbove18() {
        int age = 25;
        String expected = "All films are available.";
        String actual = FilmClassification.getClassificationsByAge(age);
        Assertions.assertEquals(expected, actual);
    }
}
