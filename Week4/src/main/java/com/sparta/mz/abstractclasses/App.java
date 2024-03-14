package com.sparta.mz.abstractclasses;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Printable square = new Square(4);
        Printable circle = new Circle(10);

        ArrayList<Printable> printables = new ArrayList<>();
        printables.add(square);
        printables.add(circle);

        for (Printable printable : printables) {
            System.out.println(printable);
        }


//        Customer customer = new Customer("Manish", "Gadhvi");
//        Customer customer1 = new Customer("Manish", "Gadhvi");
//        System.out.println(customer.equals(customer1));
//        System.out.println(customer.hashCode());
//        System.out.println(customer1.hashCode());
//
//        System.out.println("Customer Name: " + customer.getFirstName());
    }
}
