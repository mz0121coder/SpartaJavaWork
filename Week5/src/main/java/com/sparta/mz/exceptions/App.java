package com.sparta.mz.exceptions;

import java.nio.charset.IllegalCharsetNameException;
import java.text.ParseException;

public class App {
    public static void main(String[] args) {
        Animal cat = new Animal();
        Animal dog = new Animal("Fido", 10);

        try {
            System.out.println(cat.getName());
            System.out.println(dog.getName());
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }

        try {
            dog.setDob("eeeeee");
        } catch (ParseException | IllegalCharsetNameException e) {
            System.out.println("Parse Exception thrown");
        } finally {
            System.out.println("In Finally block");
        }
    }

}
