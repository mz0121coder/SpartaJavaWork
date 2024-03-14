package com.sparta.mz.abstractclasses;

public class Circle extends Shape implements Printable{
    private final double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        Circle circle = new Circle(radius);
        return (Math.PI * radius * radius);
    }

    @Override
    public void doSomethingElse() {
        Printable.super.doSomethingElse();
    }

    @Override
    public void print() {

    }
}
