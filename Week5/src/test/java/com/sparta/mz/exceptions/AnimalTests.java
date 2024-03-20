package com.sparta.mz.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class AnimalTests {
    @Test
    void checkThatTheDOBCanBeSet() throws ParseException {
        Animal animal = new Animal();
        Assertions.assertThrows(ParseException.class, () -> animal.setDob("ooo"));
    }
}
