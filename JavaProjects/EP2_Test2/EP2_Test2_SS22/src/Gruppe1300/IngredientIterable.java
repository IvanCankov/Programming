package Gruppe1300;

// Iterable objects with 'Gruppe1300.Ingredient' elements.
//
public interface IngredientIterable extends Iterable<Ingredient> {

    @Override
    // Returns an iterator over elements of 'Gruppe1300.Ingredient'.
    IngredientIterator iterator();
}
