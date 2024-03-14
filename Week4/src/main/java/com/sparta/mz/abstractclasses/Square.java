package com.sparta.mz.abstractclasses;

public class Square extends Shape implements Printable{
    private final double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double calculateArea(){
        return side * side;
    }

    @Override
    public void doSomethingElse() {
        Printable.super.doSomethingElse();
    }

    @Override
    public void print() {

    }
}