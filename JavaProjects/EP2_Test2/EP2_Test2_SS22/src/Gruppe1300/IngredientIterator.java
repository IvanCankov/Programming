package Gruppe1300;

import java.util.Iterator;

// An iterator over elements of 'Gruppe1300.Ingredient'.
//
public interface IngredientIterator extends Iterator<Ingredient> {

    @Override
    // Returns the next element in the iteration.
    Ingredient next();

    @Override
    // Returns 'true' if the iteration has more elements.
    boolean hasNext();
}
