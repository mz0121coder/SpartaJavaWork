package com.sparta.mz.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlanetsTests {
    @Test
    @DisplayName("check total distance of planets")
    public void checkTotalDistanceOfPlanets() {
        double distance = 0;
        for (Planets planet : Planets.values()) {
            distance += planet.getDistance();
        }
        Assertions.assertEquals(67.63, distance);
    }

    @Test
    @DisplayName("check total mass of planets")
    public void checkTotalMassOfPlanets() {
        double distance = 0;
        for (Planets planet : Planets.values()) {
            distance += planet.getMass();
        }
        Assertions.assertEquals(446.8500000000001, distance);
    }
}
