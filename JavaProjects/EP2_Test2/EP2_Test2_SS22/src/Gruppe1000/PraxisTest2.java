package Gruppe1000;

import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {
        /* Uncomment to test it
        SimpleSystem marsSystem, earthSystem, bodies;

        // create solar system with 12 bodies
        NamedBody sun = new NamedBody("Sun",1.989E30);
        NamedBody earth = new NamedBody("Earth",5.972E24);
        NamedBody moon = new NamedBody("Moon",7.349E22);
        NamedBody mars = new NamedBody("Mars",6.41712E23);
        NamedBody deimos = new NamedBody("Deimos",1.8E20);
        NamedBody phobos = new NamedBody("Phobos",1.08E20);
        NamedBody mercury = new NamedBody("Mercury",3.301E23);
        NamedBody venus = new NamedBody("Venus",4.86747E24);
        NamedBody vesta = new NamedBody("Vesta",2.5908E20);
        NamedBody pallas = new NamedBody("Pallas",2.14E20);
        NamedBody hygiea = new NamedBody("Hygiea",8.32E19);
        NamedBody ceres = new NamedBody("Ceres",9.394E20);

        earthSystem = new SimpleSystem(moon, earth);
        marsSystem = new SimpleSystem(deimos, mars, phobos);
        bodies = new SimpleSystem(sun, mercury, venus, vesta, pallas, hygiea, ceres);
        HierarchicalSystem solarSystem = new HierarchicalSystem(bodies, earthSystem, marsSystem);


        System.out.println("\nTest 1:");
        System.out.println(solarSystem);

        System.out.println("\nTest 2:");
        BodyIterator iter = solarSystem.iterator();

        int count = 0;
        while(iter.hasNext()) {
            count++;
            System.out.println(iter.next().getName());
        }
        System.out.println(count);

        System.out.println("\nTest 3:");
        try {
            iter.next();
            System.out.println("Test failed!");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 4:");
        HierarchicalSystem test = new HierarchicalSystem(new SimpleSystem(earth, moon),
                                        new SimpleSystem(sun, vesta, venus, pallas, hygiea, ceres,
                                                mercury),
                                        new SimpleSystem(mars, deimos, phobos));

        System.out.println(solarSystem.equals(test));

        test = new HierarchicalSystem(new SimpleSystem(earth, moon),
                new SimpleSystem(vesta, venus, pallas, hygiea, ceres,
                        mercury),
                new SimpleSystem(sun, mars, deimos, phobos));

        // sun is in a different subsystem
        System.out.println(solarSystem.equals(test));

        System.out.println("\nTest 5:");
        test = new HierarchicalSystem(new SimpleSystem(earth, moon),
                new SimpleSystem(sun, vesta, venus, pallas, hygiea, ceres,
                        mercury),
                new SimpleSystem(mars, deimos, phobos));

        System.out.println(solarSystem.hashCode() == test.hashCode());

        System.out.println("\nTest 6:");
        SimpleSystem small = new SimpleSystem(vesta, venus, pallas, hygiea, ceres,
                mercury);
        test = new HierarchicalSystem(new SimpleSystem(earth, moon),
                small,
                new SimpleSystem(mars, deimos, phobos));
        Massive mass = test.asMassive();
        System.out.println(mass.getMass());
        small.add(sun);
        System.out.println(mass.getMass());
        */

        /* Output:

        Test 1: (order is irrelevant)
        Sun: 1.989E30 kg.
        Hygiea: 8.32E19 kg.
        Ceres: 9.394E20 kg.
        Vesta: 2.5908E20 kg.
        Venus: 4.86747E24 kg.
        Mercury: 3.301E23 kg.
        Pallas: 2.14E20 kg.
        Earth: 5.972E24 kg.
        Moon: 7.349E22 kg.
        Deimos: 1.8E20 kg.
        Phobos: 1.08E20 kg.
        Mars: 6.41712E23 kg.

        Test 2: (order is irrelevant)
        Sun
        Hygiea
        Ceres
        Vesta
        Venus
        Mercury
        Pallas
        Earth
        Moon
        Deimos
        Phobos
        Mars
        12

        Test 3:
        no next body!

        Test 4:
        true
        false

        Test 5:
        true

        Test 6:
        1.1886555680000002E25
        1.9890118865556799E30

        */

    }
}
