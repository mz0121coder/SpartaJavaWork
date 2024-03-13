package com.sparta.mz.uml;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Mohammad", "Zafar");
        System.out.println(person.getDetails());;
        Customer customer = new Customer("Alex", "Blunt", "London");
        System.out.println(customer.getDetails());
    }
}
