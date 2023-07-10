package Gruppe1300;
// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {

        HierarchicalSystem solarSystem, marsSystem, earthSystem, milkyWay;

        // create solar system with 9 bodies
        NamedBody sun = new NamedBody("Sun",1.989E30);
        NamedBody earth = new NamedBody("Earth",5.972E24);
        NamedBody moon = new NamedBody("Moon",7.349E22);
        NamedBody mars = new NamedBody("Mars",6.41712E23);
        NamedBody deimos = new NamedBody("Deimos",1.8E20);
        NamedBody phobos = new NamedBody("Phobos",1.08E20);
        NamedBody mercury = new NamedBody("Mercury",3.301E23);
        NamedBody venus = new NamedBody("Venus",4.86747E24);
        NamedBody vesta = new NamedBody("Vesta",2.5908E20);
        NamedBody sagAstar = new NamedBody("Sagittarius A*", 1e40);


        earthSystem = new HierarchicalSystem(earth, new HierarchicalSystem(moon));

        marsSystem = new HierarchicalSystem(mars, new HierarchicalSystem(deimos),
                new HierarchicalSystem(phobos), earthSystem);
        // earth to massive to be added to marsSystem (should be omitted).

        solarSystem = new HierarchicalSystem(sun, new HierarchicalSystem(mercury),
                new HierarchicalSystem(venus), earthSystem, marsSystem,
                new HierarchicalSystem(vesta));

        milkyWay = new HierarchicalSystem(sagAstar, solarSystem);

        System.out.println("\nTest1:");
        System.out.println(solarSystem);
        System.out.println(milkyWay);

        System.out.println("\nTest2:");
        System.out.println(solarSystem.size());
        System.out.println(milkyWay.size());

        System.out.println("\nTest3:");
        System.out.println(solarSystem.leastMassive());
        System.out.println(milkyWay.leastMassive());

        System.out.println("\nTest4:");
        System.out.println(solarSystem.flatten());
        System.out.println(milkyWay.flatten());

        /* Output:

        Test1:
        Sun [Mercury, Venus, Earth [Moon], Mars [Deimos, Phobos], Vesta]
        Sagittarius A* [Sun [Mercury, Venus, Earth [Moon], Mars [Deimos, Phobos], Vesta]]

        Test2:
        9
        10

        Test3:
        Phobos
        Phobos

        Test4:
        Sun [Mercury, Venus, Earth, Moon, Mars, Deimos, Phobos, Vesta]
        Sagittarius A* [Sun, Mercury, Venus, Earth, Moon, Mars, Deimos, Phobos, Vesta]

        */


    }
}