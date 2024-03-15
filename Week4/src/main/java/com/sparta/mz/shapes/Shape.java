package com.sparta.mz.shapes;

public abstract class Shape {
    public abstract double calculateArea();

    public String toString() {
        return STR."This shape has an area of \{calculateArea()}";
    }
}
