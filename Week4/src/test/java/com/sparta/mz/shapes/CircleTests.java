package com.sparta.mz.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CircleTests {
    @Test
    @DisplayName("calculate radius of small circle")
    public void getSmallRadius() {
        Circle circle = new Circle(20);
        Assertions.assertEquals(1256.6370614359173, circle.calculateArea());
    }


    @Test
    @DisplayName("calculate radius of large circle")
    public void getMediumRadius() {
        Circle circle = new Circle(200);
        Assertions.assertEquals(125663.70614359173, circle.calculateArea());
    }

}
