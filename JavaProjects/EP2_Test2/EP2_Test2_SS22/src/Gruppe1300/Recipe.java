package Gruppe1300;

// Represents a recipe made of at least one basic ingredients.
//
public interface Recipe extends IngredientIterable {

    // Returns the quantity of the ingredient in this recipe.
    // Precondition: ingredient != null.
    int quantityOf(Ingredient ingredient);

    @Override
    // Returns an iterator over elements of 'Gruppe1300.Ingredient', where the
    // iterations are in the order of the recipes specified at initialization
    // of 'this'.
    IngredientIterator iterator();

}
