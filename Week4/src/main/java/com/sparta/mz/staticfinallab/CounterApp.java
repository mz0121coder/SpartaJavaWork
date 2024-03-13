package com.sparta.mz.staticfinallab;

import java.util.Random;

public class CounterApp {
    public static void main(String[] args) {
        // Create the Counters
        Counter[] theCounters = {
                new Counter("James"),
                new Counter("Avril"),
                new Counter("Rishi"),
                new Counter("Mo"),
                new Counter("John"),
                new Counter("Tom"),
                new Counter("Michelle"),
                new Counter("Mariam")
        };

        // Run the simulation
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(theCounters.length);
            theCounters[index].increment();
        }

        // Simulate people entering in groups
        for (Counter c : theCounters) {
            int numPeople = random.nextInt(1, 10); // Simulate 1 to 10 people entering at once
            c.incrementGroup(numPeople);
        }

        // Simulate people leaving
        for (Counter c : theCounters) {
            c.decrement();
        }

        // Display the results
        for (Counter c : theCounters) {
            System.out.println(c);
        }

        System.out.println("Overall count: " + Counter.getGlobalCount());
        System.out.println("People leaving: " + Counter.getPeopleLeaving());
        System.out.println("Capacity: " + Counter.getCapacity());
    }
}