package com.sparta.mz.enums;

public enum Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static void main(String[] args) {
        Days dayOfTheWeek = Days.SUNDAY;
        Days tomorrow = Days.MONDAY;
        System.out.println(dayOfTheWeek.compareTo(tomorrow));
        System.out.println(Days.valueOf("THURSDAY").ordinal());
    }
}
