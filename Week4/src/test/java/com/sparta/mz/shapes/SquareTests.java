package com.sparta.mz.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    @DisplayName("calculate area of small square")
    public void checkSmallSquareArea() {
        Square square = new Square(50);
        Assertions.assertEquals(2500, square.calculateArea());
    }

    @Test
    @DisplayName("calculate area of large square")
    public void checkLargeSquareArea() {
        Square square = new Square(500);
        Assertions.assertEquals(250000, square.calculateArea());
    }
}
