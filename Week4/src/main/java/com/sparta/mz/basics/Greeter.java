package com.sparta.mz.basics;
//Read, Maintain, Test
public class Greeter {
    public static void main(String[] args) {
        int timeOfDay = 10;
        System.out.println(getGreeting(timeOfDay));
    }

    private static String getGreeting(int timeOfDay) {
        if (timeOfDay >= 5 && timeOfDay <= 12) {
            return ("Good morning!");
        } else if (timeOfDay >= 12 && timeOfDay <= 18) {
            return ("Good afternoon!");
        } else {
            return ("Good evening!");
        }
    }
}
