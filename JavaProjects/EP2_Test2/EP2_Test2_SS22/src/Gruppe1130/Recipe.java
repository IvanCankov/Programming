package Gruppe1130;

// Represents a recipe made of at least one basic ingredients.
//
public interface Recipe extends IngredientIterable {

    // Returns the quantity of the ingredient in this recipe.
    // Precondition: ingredient != null.
    int getQuantityOf(Ingredient ingredient);
}
