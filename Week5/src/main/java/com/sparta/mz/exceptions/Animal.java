package com.sparta.mz.exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Animal {
    private String name;
    private int age;
    private Date dob;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {

    }

    public String getName() {
        try {
            return name.toUpperCase();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return "no name";
        }
    }

    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        }
    }

    public void setDob(String dateString) throws ParseException {
        dob = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
