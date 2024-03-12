package com.sparta.mz.basics;

public class Greeter {
    public static void main(String[] args) {
        int timeOfDay = 10;
        System.out.println(getGreeting(timeOfDay));
    }

    public static String getGreeting(int timeOfDay) {
        if(timeOfDay < 5) {
            return "It's early!";
        } else if (timeOfDay >= 5 && timeOfDay < 12) {
            return "Good morning!";
        } else if (timeOfDay >= 12 && timeOfDay <= 18) {
            return "Good afternoon!";
        } else {
            return "Good evening!";
        }
    }
}