package Gruppe1600;

import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

        int y = 0;
        if (true) y = -43;
        System.out.println(y >= -43);

        Interval i1 = new Interval(-1.2,5.0);
        Interval i2 = new Interval(7.33,12.5);
        Interval i3 = new Interval(21.1,28.7);

        System.out.println("\nTest 1:");

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        System.out.println("\nTest 2:");

        NonContinuousSet set = new NonContinuousSet(i2,i1,i3);
        System.out.println(set);

        System.out.println("\nTest 3:");

        ContinuousSet hull = set.getHull();
        System.out.println(hull);
        set.add(new Interval(-10,-5));
        System.out.println(hull);

        System.out.println("\nTest 4:");

        DoubleIterator iter = set.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 5:");

        System.out.println(new NonContinuousSet(i2,i1,i3).equals(new NonContinuousSet(i3,i2,i1)));
        System.out.println(new NonContinuousSet(i2,i3).equals(new NonContinuousSet(i3,i2,i1)));

        System.out.println("\nTest 6:");

        System.out.println(hull.equals(new Interval(-10.0,28.7)));
        set.add(new Interval(70,71));
        System.out.println(hull.equals(new Interval(-10.0,28.7)));

        /*

        Test 1:
        [-1.2, 5.0]
        [7.33, 12.5]
        [21.1, 28.7]

        Test 2:
        [[-1.2, 5.0], [7.33, 12.5], [21.1, 28.7]]

        Test 3:
        [-1.2, 28.7]
        [-10.0, 28.7]

        Test 4:
        -10.0
        -5.0
        -1.2
        5.0
        7.33
        12.5
        21.1
        28.7
        no next value!

        Test 5:
        true
        false

        Test 6:
        true
        false

        */

    }
}
