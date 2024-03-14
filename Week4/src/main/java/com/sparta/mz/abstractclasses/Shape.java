package com.sparta.mz.abstractclasses;

public abstract class Shape {
    public abstract double calculateArea();

    @Override
    public String toString(){
        return "This shape has an area of " + calculateArea();
    }
}
