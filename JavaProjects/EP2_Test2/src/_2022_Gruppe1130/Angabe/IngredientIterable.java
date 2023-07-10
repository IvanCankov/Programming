package _2022_Gruppe1130.Angabe;

// Iterable objects with 'Gruppe1130.Gruppe1300.Ingredient' elements.
//
public interface IngredientIterable extends Iterable<Ingredient> {

    @Override
    // Returns an iterator over elements of 'Gruppe1130.Gruppe1300.Ingredient'.
    IngredientIterator iterator();
}
