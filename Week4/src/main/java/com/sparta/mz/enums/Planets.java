package com.sparta.mz.enums;

public enum Planets {
    MERCURY(0.39, 0.33),
    VENUS(0.72, 0.81),
    EARTH(1, 1),
    MARS(1.52, 0.11),
    JUPITER(5.2, 317.8),
    SATURN(9.54, 95.16),
    URANUS(19.2, 14.54),
    NEPTUNE(30.06, 17.1);

    private double distance;
    private double mass;

    Planets(double distance, double mass) {
        this.distance = distance;
        this.mass = mass;
    }

    public double getDistance() {
        return distance;
    }

    public double getMass() {
        return mass;
    }

    public static void main(String[] args) {
        Planets myPlanet = Planets.EARTH;

        // accessing values
        System.out.println("Average distance from the sun of Earth: " + myPlanet.getDistance());
        System.out.println("Mass of Earth: " + myPlanet.getMass());

        // comparison using ==
        if (myPlanet == Planets.EARTH) {
            System.out.println("My planet is Earth.");
        }

        //  comparison using .equals()
        Planets anotherPlanet = Planets.MARS;
        if (myPlanet.equals(anotherPlanet)) {
            System.out.println("These two planets are the same.");
        } else {
            System.out.println("These two planets are different.");
        }
    }
}
