package com.sparta.pcw.codesmellsrefactoring;

public class Weapon {

    private final WeaponType weaponType;
    private final String brand;

    public Weapon(WeaponType type, String brand)
    {
        this.weaponType = type;
        this.brand = brand;
    }

    public String shoot()
    {
        String result = weaponType.name() + " - " + brand;

        result = switch (weaponType) {
            case WaterPistol -> "Splash!! " + result;
            case BubbleBlaster -> "Bubbles... " + result;
            case LaserGun -> "Zing!! " + result;
        };

        return result;
    }
}
