package com.sparta.mz.generics;

public class App {
    public static void main(String[] args) {
        IntegerRectangle integerRectangle = new IntegerRectangle(2, 4);
        System.out.printf("Integer Rectangle Area: %d\n", integerRectangle.getWidth() * integerRectangle.getHeight());

        GenericRectangle<Double> doubleGenericRectangle = new GenericRectangle<>(2.1, 4.2);
        System.out.printf("Integer Rectangle Area: %f\n", doubleGenericRectangle.getWidth() * doubleGenericRectangle.getHeight());
    }
}
