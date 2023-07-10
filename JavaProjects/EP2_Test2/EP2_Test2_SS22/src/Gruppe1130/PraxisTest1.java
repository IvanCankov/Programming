package Gruppe1130;
// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {
        NamedBody sun = new NamedBody("Sun",1.989E30, new Vector2(0,0));
        NamedBody earth = new NamedBody("Earth",5.972E24, new Vector2(150,1));
        NamedBody moon = new NamedBody("Moon",7.349E22, new Vector2(150,0));
        NamedBody mars = new NamedBody("Mars",6.41712E23, new Vector2(227,-1));
        NamedBody deimos = new NamedBody("Deimos",1.8E20, new Vector2(227,0));
        NamedBody phobos = new NamedBody("Phobos",1.08E20, new Vector2(227,1));
        NamedBody mercury = new NamedBody("Mercury",3.301E23, new Vector2(58,0));
        NamedBody venus = new NamedBody("Venus",4.86747E24, new Vector2(107,0));
        NamedBody vesta = new NamedBody("Vesta",2.5908E20, new Vector2(353,0));

        System.out.println("Test1:");
        System.out.println(sun.toString());
        System.out.println(earth.toString());

        System.out.println("Test2:");
        NamedBodyList map = new NamedBodyList();
        map.insert(vesta);
        map.insert(moon);
        map.insert(sun);
        map.insert(earth);
        map.insert(deimos);
        map.insert(phobos);
        map.insert(mercury);
        map.insert(venus);
        map.insert(mars);
        System.out.println(map.toString());

        System.out.println("Test3:");
        System.out.println(map.get(new Vector2(227,0)));
        System.out.println(map.get(new Vector2(227,-1)));
        System.out.println(map.get(new Vector2(1,0)));

        System.out.println("Test4:");
        System.out.println(map.getBodiesAtX(227));
        System.out.println(map.getBodiesAtX(-1));

        System.out.println("Test5:");
        map.insert(new NamedBody("Comet", 1e21, new Vector2(353,0)));
        map.insert(new NamedBody("Melancholia", 0.7e25,new Vector2(150,1)));
        System.out.println(map);

        /*
        Test1:
        Sun: 1.989E30 (0,0)
        Earth: 5.972E24 (150,1)

        Test2:
        Sun: 1.989E30, (0,0)
        Mercury: 3.301E23, (58,0)
        Venus: 4.86747E24, (107,0)
        Moon: 7.349E22, (150,0)
        Earth: 5.972E24, (150,1)
        Mars: 6.41712E23, (227,-1)
        Deimos: 1.8E20, (227,0)
        Phobos: 1.08E20, (227,1)
        Vesta: 2.5908E20, (353,0)

        Test3:
        Deimos: 1.8E20 (227,0)
        Mars: 6.41712E23 (227,-1)
        null

        Test4:
        Mars: 6.41712E23, (227,-1)
        Deimos: 1.8E20, (227,0)
        Phobos: 1.08E20, (227,1)
        EMPTY

        Test5:
        Sun: 1.989E30, (0,0)
        Mercury: 3.301E23, (58,0)
        Venus: 4.86747E24, (107,0)
        Moon: 7.349E22, (150,0)
        Melancholia: 1.2972E25, (150,1)
        Mars: 6.41712E23, (227,-1)
        Deimos: 1.8E20, (227,0)
        Phobos: 1.08E20, (227,1)
        Comet: 1.25908E21, (353,0)
        */

    }
}
