package Gruppe1430;
// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {

        // create solar system with 12 bodies
        NamedBody sun = new NamedBody("Sun", new Vector3(0.0,0.0,0.0));
        NamedBody earth = new NamedBody("Earth", new Vector3(-6.13135922534815E10,
                -1.383789852227691E11,2.719682263474911E7));
        NamedBody moon = new NamedBody("Moon", new Vector3(-6.132484773775896E10,
                -1.387394951280871E11,1.701046736294776E7));
        NamedBody mars = new NamedBody("Mars", new Vector3(-1.7923193702925848E11,1.726665823982123E11,7.991673845249474E9));
        NamedBody deimos = new NamedBody("Deimos", new Vector3(-1.792255010450533E11,1.726891122683271E11,7.990659337380297E9));
        NamedBody phobos = new NamedBody("Phobos", new Vector3(-1.792253482539647E11,1.72661109673625E11,7.987848354800322E9));
        NamedBody mercury = new NamedBody("Mercury", new Vector3(-5.167375560011926E10,
        -4.217574885682655E10,1.14808913958168E9));
        NamedBody venus = new NamedBody("Venus", new Vector3(-3.123150865740532E10,1.0395568504115701E11,3.173401325838074E9));
        NamedBody vesta = new NamedBody("Vesta", new Vector3(-3.337493557929893E11,-4.7147908276077385E10,4.1923010146878105E10));
        NamedBody pallas = new NamedBody("Pallas", new Vector3(4.3452066613895575E11,-2.057319365171432E11,1.0549957423213101E11));
        NamedBody hygiea = new NamedBody("Hygiea", new Vector3(-3.983943433707043E11,2.325833000024021E11,-2.233667695713672E10));
        NamedBody ceres = new NamedBody("Ceres", new Vector3(3.781372641419032E11,1.96718960466285E11,-6.366459168068592E10));

        System.out.println("\nTest1:");
        NamedBodyTree tree = new NamedBodyTree();
        System.out.println(tree.add(sun));
        System.out.println(tree.add(sun));
        tree.add(earth);
        tree.add(moon);
        tree.add(mars);
        tree.add(deimos);
        tree.add(phobos);
        tree.add(mercury);
        tree.add(venus);
        tree.add(vesta);
        tree.add(pallas);
        tree.add(hygiea);
        tree.add(ceres);
        System.out.println(tree.add(moon));

        System.out.println("\nTest2:");
        System.out.println(tree.toString());

        System.out.println("\nTest3:");
        System.out.println(tree.contains(venus));
        System.out.println(tree.contains(new NamedBody("Venus",
                new Vector3(-3.123150865740532E10,1.0395568504115701E11,
                3.173401325838074E9))));

        System.out.println("\nTest4:");
        System.out.println(tree.getDistantBodies(150e9));

        System.out.println("\nTest5:");
        System.out.println(tree.getDistantBodies(250e9));

        /* Output:

        Test1:
        true
        false
        false

        Test2:
        Sun: 0.0 m.
        Mercury: 6.6710485818403305E10 m.
        Venus: 1.0859218232160477E11 m.
        Earth: 1.5135422321817352E11 m.
        Moon: 1.5168844632275665E11 m.
        Phobos: 2.4899275084191058E11 m.
        Mars: 2.490014111991889E11 m.
        Deimos: 2.4901236988856467E11 m.
        Vesta: 3.3966026633508374E11 m.
        Ceres: 4.3097484865538007E11 m.
        Hygiea: 4.618570898094664E11 m.
        Pallas: 4.9220320922165533E11 m.

        Test3:
        true
        false

        Test4:
        Earth: 1.5135422321817352E11 m.
        Moon: 1.5168844632275665E11 m.
        Phobos: 2.4899275084191058E11 m.
        Mars: 2.490014111991889E11 m.
        Deimos: 2.4901236988856467E11 m.
        Vesta: 3.3966026633508374E11 m.
        Ceres: 4.3097484865538007E11 m.
        Hygiea: 4.618570898094664E11 m.
        Pallas: 4.9220320922165533E11 m.

        Test5:
        Vesta: 3.3966026633508374E11 m.
        Ceres: 4.3097484865538007E11 m.
        Hygiea: 4.618570898094664E11 m.
        Pallas: 4.9220320922165533E11 m.

        */
    }
}
