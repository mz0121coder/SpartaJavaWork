package com.sparta.mz.staticfinallab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CounterTests {
    @Test
    @DisplayName("when attendees have all joined, capacity should be greater than overall count")
    public void checkCapacityIsCorrect(){
    Counter counter = new Counter("Test Counter");
    Assertions.assertTrue(Counter.getCapacity() > Counter.getGlobalCount());
    }

    @Test
    @DisplayName("current count, head count, capacity and people leaving should always be at least 0")
    public void checkLeavingEqualsHeadcount(){
        CounterApp counter = new CounterApp();
        Assertions.assertTrue(Counter.getGlobalCount() >= 0 && Counter.getCapacity() >= 0 && Counter.getPeopleLeaving() >= 0);
    }
}
