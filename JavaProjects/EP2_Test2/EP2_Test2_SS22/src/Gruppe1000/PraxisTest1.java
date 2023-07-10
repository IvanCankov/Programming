package Gruppe1000;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {
        /* Uncomment to test it
        HierarchicalSystem solarSystem, marsSystem, earthSystem;

        // create solar system with 12 bodies
        NamedBody sun = new NamedBody("Sun",1.989E30, new Vector3(0.0,0.0,0.0));
        NamedBody earth = new NamedBody("Earth",5.972E24, new Vector3(-6.13135922534815E10,-1.383789852227691E11,2.719682263474911E7));
        NamedBody moon = new NamedBody("Moon",7.349E22, new Vector3(-6.132484773775896E10,-1.387394951280871E11,1.701046736294776E7));
        NamedBody mars = new NamedBody("Mars",6.41712E23, new Vector3(-1.7923193702925848E11,1.726665823982123E11,7.991673845249474E9));
        NamedBody deimos = new NamedBody("Deimos",1.8E20, new Vector3(-1.792255010450533E11,1.726891122683271E11,7.990659337380297E9));
        NamedBody phobos = new NamedBody("Phobos",1.08E20, new Vector3(-1.792253482539647E11,1.72661109673625E11,7.987848354800322E9));
        NamedBody mercury = new NamedBody("Mercury",3.301E23, new Vector3(-5.167375560011926E10,
        -4.217574885682655E10,1.14808913958168E9));
        NamedBody venus = new NamedBody("Venus",4.86747E24, new Vector3(-3.123150865740532E10,1.0395568504115701E11,3.173401325838074E9));
        NamedBody vesta = new NamedBody("Vesta",2.5908E20, new Vector3(-3.337493557929893E11,-4.7147908276077385E10,4.1923010146878105E10));
        NamedBody pallas = new NamedBody("Pallas",2.14E20, new Vector3(4.3452066613895575E11,-2.057319365171432E11,1.0549957423213101E11));
        NamedBody hygiea = new NamedBody("Hygiea",8.32E19, new Vector3(-3.983943433707043E11,2.325833000024021E11,-2.233667695713672E10));
        NamedBody ceres = new NamedBody("Ceres",9.394E20, new Vector3(3.781372641419032E11,1.96718960466285E11,-6.366459168068592E10));

        earthSystem = new HierarchicalSystem(earth, new HierarchicalSystem(moon));
        marsSystem = new HierarchicalSystem(mars, new HierarchicalSystem(deimos),
                new HierarchicalSystem(phobos));
        solarSystem = new HierarchicalSystem(sun, new HierarchicalSystem(mercury),
                new HierarchicalSystem(venus), earthSystem, marsSystem,
                new HierarchicalSystem(vesta),
                new HierarchicalSystem(pallas),
                new HierarchicalSystem(hygiea),
                new HierarchicalSystem(ceres));

        System.out.println("\nTest1:");
        System.out.println(solarSystem);

        System.out.println("\nTest2:");
        System.out.println(earthSystem.withinRange(new HierarchicalSystem(moon, null), 5e8));
        System.out.println(earthSystem.withinRange(marsSystem, 5e8));

        System.out.println("\nTest3:");
        System.out.println(earthSystem.countWithinRange(phobos, 5e8));
        System.out.println(marsSystem.countWithinRange(phobos, 5e8));
        System.out.println(solarSystem.countWithinRange(moon, 5e8));
        System.out.println(solarSystem.countWithinRange(new NamedBody("Comet", 1e12,
                new Vector3(1e10, 0, 0)), 5e8));
        System.out.println(solarSystem.countWithinRange(new NamedBody("Comet", 1e12,
                new Vector3(-6.132484E10,-1.387394E11,1.701046E7)), 3e8));
        */

        /* Output:

        Test1:
        Sun: 1.989E30 kg
            Mercury: 3.301E23 kg
            Venus: 4.86747E24 kg
            Earth: 5.972E24 kg
                Moon: 7.349E22 kg
            Mars: 6.41712E23 kg
                Phobos: 1.08E20 kg
                Deimos: 1.8E20 kg
            Vesta: 2.5908E20 kg
            Pallas: 2.14E20 kg
            Hygiea: 8.32E19 kg
            Ceres: 9.394E20 kg

        Test2:
        true
        false

        Test3:
        0
        3
        2
        0
        1

        */


    }
}
