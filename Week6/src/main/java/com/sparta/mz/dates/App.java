package com.sparta.mz.dates;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        LocalDate myDate = LocalDate.now(); // YYYY-MM-DD
        System.out.println(myDate);
        LocalDate anotherDate = LocalDate.of(2011, Month.APRIL, 11);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM, yy");
        System.out.println(myDate.format(dateTimeFormatter));
        LocalDate yetAnotherDate = LocalDate.parse("2001-11-11", dateTimeFormatter);
        System.out.println(yetAnotherDate);
    }
}
