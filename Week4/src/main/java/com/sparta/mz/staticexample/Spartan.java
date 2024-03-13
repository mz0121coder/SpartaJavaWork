package com.sparta.mz.staticexample;

public class Spartan {
    private static String name; //Belongs to the class

    static {
        // once when the class is loaded
        System.out.println("I am in a static block");
        name = "No name assigned";
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Spartan.name = name;
    }

    public static void main(String[] args) {
        Spartan manish = new Spartan();
        Spartan alex = new Spartan();

//        manish.setName("Manish");
//        alex.setName("Alex");

        System.out.println(manish.getName());
        System.out.println(alex.getName());
    }
}
