package Gruppe1130;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {
        /* Uncomment to test it
        Milk milk = new Milk();
        Egg egg = new Egg();
        Flour flour = new Flour();

        System.out.println("Test 1:");
        SimpleRecipe scrambledEgg = new SimpleRecipe();
        scrambledEgg.put(egg, 100);

        SimpleRecipe dumplings = new SimpleRecipe();
        dumplings.put(egg, 50);
        dumplings.put(flour, 300);
        dumplings.put(milk, 250);
        ComplexRecipe eggDumplings = new ComplexRecipe(dumplings, scrambledEgg);
        System.out.println(eggDumplings);

        System.out.println("\nTest 2:");
        SimpleRecipe r1 = new SimpleRecipe();
        r1.put(flour,300);
        r1.put(egg,50);
        SimpleRecipe r2 = new SimpleRecipe();
        r2.put(egg,50);
        r2.put(flour,300);
        System.out.println(r1.equals(r2));

        r1 = new SimpleRecipe();
        r1.put(egg,50);
        r1.put(flour,300);
        r1.put(flour,1);
        r2 = new SimpleRecipe();
        r2.put(egg,50);
        r2.put(flour,300);
        System.out.println(r1.equals(r2));

        r1 = new SimpleRecipe();
        r1.put(egg,50);
        r1.put(flour,300);
        r1.put(milk,1);
        r2 = new SimpleRecipe();
        r2.put(egg,50);
        r2.put(flour,300);
        System.out.println(r1.equals(r2));

        System.out.println("\nTest 3:");
        IngredientIterator iterator = eggDumplings.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        try {
            iterator.next();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 4:");
        iterator = dumplings.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        try {
            iterator.next();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 5:");
        Scale scale = dumplings.getScale();

        System.out.println(scale.getGrams());
        dumplings.put(flour,20);
        System.out.println(scale.getGrams());
        */

        /*

        Test 1:
        [{Gruppe1130.Gruppe1300.Egg=50, Gruppe1130.Gruppe1300.Flour=300, Gruppe1130.Gruppe1300.Milk=250}, {Gruppe1130.Gruppe1300.Egg=100}]

        Test 2:
        true
        false
        false

        Test 3:
        Gruppe1130.Gruppe1300.Egg
        Gruppe1130.Gruppe1300.Flour
        Gruppe1130.Gruppe1300.Milk
        Gruppe1130.Gruppe1300.Egg
        no next recipe!

        Test 4:
        Gruppe1130.Gruppe1300.Egg
        Gruppe1130.Gruppe1300.Flour
        Gruppe1130.Gruppe1300.Milk
        no next ingredient!

        Test 5:
        600
        620

         */
    }
}
