package com.sparta.pcw.codesmellsrefactoring;

import java.util.ArrayList;
import java.util.List;

public class SafariApp {
    public static void main(String[] args) {

        BaseClass p = new BaseClass("Katie", "King");
        Hunter cathy = new Hunter("Cathy",
                                  "French",
                                  new Weapon(WeaponType.LaserGun, "BlastEmUp"));

        System.out.println(p.toString());
        System.out.println(cathy.shootWeapon());

        List<Weapon> theWeapons = new ArrayList<Weapon>();
        theWeapons.add(new Weapon(WeaponType.LaserGun, "ToysRUs"));
        theWeapons.add(new Weapon(WeaponType.WaterPistol, "Supersoaker"));
        theWeapons.add(new Weapon(WeaponType.LaserGun, "ZippaZap"));

        for (Weapon w : theWeapons)
        {
            System.out.println(w.shoot());
        }
    }
}
