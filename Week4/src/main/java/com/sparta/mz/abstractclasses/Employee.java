package com.sparta.mz.abstractclasses;

public abstract class Employee extends Person implements Printable{
    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void delete(){
        System.out.println("Employee has been deleted");
    }
}
