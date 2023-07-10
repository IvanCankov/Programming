package Gruppe1130;

// Iterable objects with 'Gruppe1130.Gruppe1300.Ingredient' elements.
//
public interface IngredientIterable extends Iterable<Ingredient> {

    @Override
    // Returns an iterator over elements of 'Gruppe1130.Gruppe1300.Ingredient'.
    IngredientIterator iterator();
}
