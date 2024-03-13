package com.sparta.mz.staticfinallab;

import java.util.Random;

public class Counter {
    private final String name;
    private int count;
    private static int globalCount = 0;
    private static final int CAPACITY;
    private static int peopleLeaving = 0;

    static {
        CAPACITY = new Random().nextInt(30, 120);
    }

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        if (globalCount < CAPACITY) {
            count++;
            globalCount++;
        }
    }

    public void incrementGroup(int numPeople) {
        if (globalCount + numPeople <= CAPACITY) {
            count += numPeople;
            globalCount += numPeople;
        }
    }

    public void decrement() {
        if (count > 0) {
            count--;
            globalCount--;
            peopleLeaving++;
        }
    }

    public static int getGlobalCount() {
        return globalCount;
    }

    public static int getCapacity() {
        return CAPACITY;
    }

    public static int getPeopleLeaving() {
        return peopleLeaving;
    }

    @Override
    public String toString() {
        return name + ": " + count;
    }
}