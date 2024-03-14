package com.sparta.mz.abstractclasses;

public interface Printable {
    int score = 0;

    short print();

    static void doSomething() {

    }

    default void doSomethingElse() {
        System.out.println("Hello");
    }
}
