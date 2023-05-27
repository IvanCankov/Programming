// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {

        Camel c1 = new Camel(10, 2);
        Camel c2 = new Camel(5, 2);
        Camel c3 = new Camel(7, 3);
        Camel c4 = new Camel(12, 3);
        Camel c5 = new Camel(20, 10);
        Camel c6 = new Camel(2, 0);

        System.out.println("Test add method:");
        Caravan l1 = new Caravan();
        l1.addLast(c1);
        l1.addLast(c2);
        l1.addLast(c4);
        l1.addLast(c5);
        l1.addLast(c6);

        System.out.println("Test size method:");
        testValue(l1.size(), 5);

        System.out.println("Test insertBefore method:");
        l1.insertBefore(12, c3);
        testValue(l1.size(), 6);

        System.out.println("Test toString method:");
        testEquals(new Caravan().toString(), "[]");
        testEquals(l1.toString(), "[(10-2=8), (5-2=3), (7-3=4), (12-3=9), (20-10=10), (2-0=2)] pace = 2");


        System.out.println("Test detachFront method with size:");
        Caravan l2 = l1.detachFront(4);
        testValue(l1.size(), 2);
        testValue(l2.size(), 4);

        System.out.println("Test detachFront method with toString:");
        testEquals(l1.toString(), "[(20-10=10), (2-0=2)] pace = 2");
        testEquals(l2.toString(), "[(10-2=8), (5-2=3), (7-3=4), (12-3=9)] pace = 3");

    }

    public static void testIdentical(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    public static void testNotIdentical(Object given, Object expected) {
        if (given != expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    public static void testEquals(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
            return;
        } else {
            if (given == null) {
                System.out.println("Test NOT successful! Expected value: " +
                        expected +
                        " / Given value: null");
                return;
            }
            if (expected == null) {
                System.out.println("Test NOT successful! Expected value: null / " +
                        "Given value: " + given);
                return;
            }
        }
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }

    public static void testTrue(boolean expectedTrue) {
        if (expectedTrue) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expression should be 'true' but is 'false'.");
        }
    }

    public static void testValue(int given, int expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

}
