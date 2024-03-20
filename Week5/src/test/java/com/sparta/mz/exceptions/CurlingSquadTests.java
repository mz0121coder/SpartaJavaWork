package com.sparta.mz.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurlingSquadTests {
    @Test
    @DisplayName(("Add some curlers"))
    public void testAddSomeCurlers() {
        CurlingSquad squadSparta = new CurlingSquad("Sparta");
        String[] availableCurlers = new String[]{"Cathy", "Nikki", "Alicja", "Elena"};
        Assertions.assertEquals(4, squadSparta.addCurlers(availableCurlers));
    }

    @Test
    @DisplayName(("Try to add too many curlers"))
    public void testAddTooManyCurlers() {
        CurlingSquad squadSparta = new CurlingSquad("Sparta");
        String[] availableCurlers = new String[]{"Cathy", "Nikki", "Alicja", "Elena"};
        Assertions.assertEquals(4, squadSparta.addCurlers(availableCurlers));
        String[] moreCurlers = new String[]{"Parmita", "Millie", "Jasmine"};
        Assertions.assertThrows(Exception.class, () -> squadSparta.addCurlers(availableCurlers));
    }


    @Test
    @DisplayName("Try to add too many curlers and verify exception message")
    public void testAddTooManyCurlersExceptionMessage() {
        CurlingSquad squadSparta = new CurlingSquad("Sparta");
        String[] availableCurlers = new String[]{"Cathy", "Nikki", "Alicja", "Elena"};
        Assertions.assertEquals(4, squadSparta.addCurlers(availableCurlers));
        String[] moreCurlers = new String[]{"Parmita", "Millie", "Jasmine"};
        Exception exception = Assertions.assertThrows(Exception.class, () -> squadSparta.addCurlers(moreCurlers));
        String expectedMessage = "Squad is full";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
