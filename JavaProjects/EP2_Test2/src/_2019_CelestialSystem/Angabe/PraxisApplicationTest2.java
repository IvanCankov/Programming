package _2019_CelestialSystem.Angabe;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplicationTest2 {

    public static void main(String[] args) {
/*

        CelestialBody earth, moon, sun, mars, phobos, deimos, mercury;

        earth = new CelestialBody("Earth", 5.97237e24);
        moon = new CelestialBody("Moon", 7.349e22);
        mars = new CelestialBody("Mars", 6.419e23);
        phobos = new CelestialBody("Phobos", 1.072e16);
        deimos = new CelestialBody("Deimos", 1.8e15);
        mercury = new CelestialBody("Mercury", 0.330114e23);
        sun = new CelestialBody("Sun", 1.989e30);

        CelestialSystem earthSystem = earth.merge(moon);
        CelestialSystem earthSystem2 =
                new CelestialBody("Earth", 5.97237e24).merge(new CelestialBody("Moon", 7.349e22));
        CelestialSystem marsSystem = mars.merge(phobos).merge(deimos);
        CelestialSystem solarSystem = sun.merge(earthSystem).merge(marsSystem).merge(mercury);
        System.out.println(earthSystem.equals(earthSystem2)); // true
        System.out.println(earthSystem.equals(solarSystem)); // false

        System.out.println(solarSystem); // Sun, Earth, Moon, Mars, Phobos, Deimos, Mercury
                                         // (order is not specified)

        for (CelestialBody b: solarSystem) {
            System.out.println(b);
        }
        // Sun
        // Earth
        // Moon
        // Mars
        // Phobos
        // Deimos
        // Mercury
        // (order is irrelevant)

        for (CelestialBody b: earthSystem) {
            System.out.println(b);
        }
        // Earth
        // Moon
        // (order is irrelevant)

        System.out.println(solarSystem.getMass()); // 1.9890067207714123E30
        System.out.println(marsSystem.getMass()); // 6.4190001252E23

        Catalog catalog = new Catalog();
        catalog.put(earthSystem, "Earth system");
        catalog.put(marsSystem, "Mars system");

        System.out.println(catalog.get(new CelestialBody("Moon", 0).merge(
                new CelestialBody("Earth", 0))));
        // Earth system

        System.out.println(catalog.get(new CelestialBody("Mars", 0).merge(
                new CelestialBody("Deimos", 0)).merge(new CelestialBody("Phobos",0))));
        // Mars system

        System.out.println(catalog.get(moon));
        // null

        // TODO: end of block to uncomment. */

    }
}

