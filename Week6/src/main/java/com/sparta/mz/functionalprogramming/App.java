package com.sparta.mz.functionalprogramming;

public class App {
    public static void main(String[] args) {
        Calculatable myScore = Integer::sum;
        System.out.println(myScore.calculateScore(5, 10));
        Multiplicable myProduct = (number1, number2) -> number1 * number2;
        System.out.println(myProduct.calculateProduct(5, 10));
    }
}
