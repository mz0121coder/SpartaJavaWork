package com.sparta.mz.abstractclasses;

import com.sparta.mz.abstractclasses.Customer;

public class App {
    public static void main(String[] args) {
//        Printable square = new Square(4);
//        Printable circle = new Circle(10);
//        Printable customer = new Customer("Manish", "Gadhvi");
//        Printable employee = new Employee("John", "Doe");
//
//        ArrayList<Printable> printables = new ArrayList<Printable>();
//        printables.add(square);
//        printables.add(circle);
//        printables.add(customer);
//        printables.add(employee);
//
//        for(Printable printable: printables) {
//            printable.
//            print();
//        }
        Customer customer = new Customer("Manish", "Gadhvi");
        Customer customer1 = new Customer("Manish", "Gadhvi");
        System.out.println(customer.equals(customer1));
        System.out.println();

    }
}
