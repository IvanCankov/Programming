package Gruppe1300;

import java.util.*;

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
        Recipe scrambledEgg = new RecipeList(egg, egg); //two eggs
        RecipeList dumplings = new RecipeList(egg, flour, milk);
        RecipeList eggDumplings = new RecipeList(dumplings);
        eggDumplings.add(egg);
        RecipeList pancake = new RecipeList(scrambledEgg, milk, flour);
        System.out.println(pancake);
        System.out.println(eggDumplings);

        System.out.println("\nTest 2:");
        IngredientIterator iterator = eggDumplings.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nTest 3:");
        try {
            iterator.next();
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 4:");
        System.out.println(pancake.equals(eggDumplings));
        RecipeList copy = new RecipeList(new RecipeList(egg, egg), milk, flour);
        System.out.println(pancake.equals(copy));
        copy = new RecipeList(new RecipeList(egg, flour, milk), egg);
        System.out.println(eggDumplings.equals(copy));

        System.out.println("\nTest 5:");
        System.out.println(dumplings.getShoppingMap());
        System.out.println(eggDumplings.getShoppingMap());
        System.out.println(pancake.getShoppingMap());

        System.out.println("\nTest 6:");
        ShoppingMap sPancake = pancake.getShoppingMap();
        ShoppingMap sDumplings = dumplings.getShoppingMap();
        ShoppingMap sEggDumplings = eggDumplings.getShoppingMap();

        System.out.println(sDumplings.equals(sEggDumplings));
        System.out.println(sPancake.equals(sEggDumplings));

        System.out.println("\nTest 7:");
        eggDumplings.add(egg);
        System.out.println(sPancake.equals(sEggDumplings));

        RecipeList test3 = new RecipeList(egg,egg);
        RecipeList test4 = new RecipeList(egg,new RecipeList(egg));
        System.out.println("\nExtra Test:");
        System.out.println(test3.equals(test4));
         */
        /*

        Test 1:
        [[Gruppe1300.Egg, Gruppe1300.Egg], Gruppe1300.Milk, Gruppe1300.Flour]
        [[Gruppe1300.Egg, Gruppe1300.Flour, Gruppe1300.Milk], Gruppe1300.Egg]

        Test 2:
        Gruppe1300.Egg
        Gruppe1300.Flour
        Gruppe1300.Milk
        Gruppe1300.Egg

        Test 3:
        no next ingredient!

        Test 4:
        false
        true
        true

        Test 5:
        {Gruppe1300.Egg=1, Gruppe1300.Flour=1, Gruppe1300.Milk=1}
        {Gruppe1300.Egg=2, Gruppe1300.Flour=1, Gruppe1300.Milk=1}
        {Gruppe1300.Egg=2, Gruppe1300.Flour=1, Gruppe1300.Milk=1}

        Test 6:
        false
        true

        Test 7:
        false

        */

    }
}
