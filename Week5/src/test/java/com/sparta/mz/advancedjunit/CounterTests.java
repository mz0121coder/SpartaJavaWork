package com.sparta.mz.advancedjunit;

import org.junit.jupiter.api.*;

public class CounterTests {
    private static Counter counter;

    @BeforeEach
    void setupAll() {
        counter = new Counter(6);
    }

    @Test
    @DisplayName("decrement counter by 1")
    void decrementCounterByOne() {
        counter.decrement();
        Assumptions.assumeTrue(counter.getCount() == 100);
        Assertions.assertEquals(5, counter.getCount());
    }

    @Test
    @DisplayName("increment counter by 1")
    void incrementCounterByOne() {
        counter.increment();
        Assertions.assertEquals(7, counter.getCount());
    }
}
