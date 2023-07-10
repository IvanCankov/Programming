package _2022_Gruppe1430.Angabe;

import java.util.Arrays;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

/*

        Interval i1 = new Interval(-1.2, 2.0);
        Interval i2 = new Interval(7.33, 10.5);
        Interval i3 = new Interval(19.9, 21.1);
        ComposedSet set = new ComposedSet(i1, new ComposedSet(i2, i3));

        System.out.println("\nTest 1:");
        System.out.println(i1);

        System.out.println("\nTest 2:");

        IntegerIterator iter = set.getIntegers().iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("\nTest 3:");

        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 4:");
        System.out.println(set);

        IntegerSequence sequence = set.getIntegers();
        System.out.println(sequence.length());
        set.add(new Interval(25, 28.5));
        System.out.println(set);
        System.out.println(sequence.length());
        for (Integer i : sequence) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nTest 5:");
        set = new ComposedSet(i1, new ComposedSet(i2, i3));
        System.out.println(set.equals(new ComposedSet(new ComposedSet(i1, i2), new Interval(19.9, 21.1)))); //true
        System.out.println(set.equals(new ComposedSet(i1, i3))); //false
        System.out.println(set.hashCode() == (new ComposedSet(new ComposedSet(i1, i2), new Interval(19.9, 21.1))).hashCode()); //true

        System.out.println("\nTest 6:");
        System.out.println(Arrays.deepToString(set.asArray()));

*/

        /*
        Test 1:
        from -1.2 to 2.0

        Test 2:
        -1 0 1 2 8 9 10 20 21

        Test 3:
        no next integer!

        Test 4:

        from -1.2 to 2.0 and then from 7.33 to 10.5 and then from 19.9 to 21.1
        9
        from -1.2 to 2.0 and then from 7.33 to 10.5 and then from 19.9 to 21.1 and then from 25.0 to 28.5
        13
        -1 0 1 2 8 9 10 20 21 25 26 27 28

        Test 5:
        true
        false
        true

        Test 6:
        from -1.2 to 5.0 and then from 5.5 to 5.6 and then from 6.0 to 7.0 and then from 7.33 to 12.5 and then from 20.0 to 25.0 and then from 30.1 to 37.0

        */

    }
}
