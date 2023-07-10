package Gruppe1300;

// A recipe as a list of multiple recipes. The order is relevant.
// Since entries in the list are themselves recipes, this class
// represents a recursive structure.
// RecipeList is subtype of Recipe.
// The availability of a large number of ingredients has to be
// assumed, not just those three currently used in this project.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class RecipeList {

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

    // Initializes 'this' with recipes in the specified order.
    // Precondition: recipes != null, recipes.length > 0
    public RecipeList(Recipe... recipes) {
        // TODO: implement constructor.
    }

    // Adds a recipe at the end of this list.
    // Precondition: toAdd != null.
    public void add(Recipe toAdd) {
        // TODO: implement method.
    }

    // Returns a ShoppingMap view of 'this'. Later changes in 'this' will be
    // reflected in the returned view.
    public ShoppingMap getShoppingMap() {
        // TODO: implement method.
        return null;
    }

    // Returns 'true' if 'obj' is of class 'Gruppe1300.RecipeList' and contains equal recipes in
    // the same order as in 'this', i.e. 'this' and 'obj' have the same hierarchical structure.
    // Otherwise, the method returns 'false'.
    @Override
    public boolean equals(Object o) {
        // TODO: implement method.
        return false;
    }

    // Returns an iterator over elements of Ingredient, where the
    // iterations are in the order of the recipes specified at initialization
    // of 'this'. For example if the structure is [[Egg, Egg], Milk, Flour],
    // the iterator returns the elements 'Egg', 'Egg', 'Milk', 'Flour' in this order.
    // The iterator's 'next()' method throws a 'java.util.NoSuchElementException with the message
    // "no next ingredient!" if the iteration has no more elements.
    // (See also examples in 'PraxisTest2.java'.)
    public IngredientIterator iterator() {
        // TODO: implement method.
        return null;
    }

    @Override
    // Returns a readable representation with all the recipe components of 'this' in the
    // order specified at initialization of 'this'.
    // The format is reflecting the structure of the recipe and is shown in the following
    // example:
    // [[Egg, Egg], Milk, Flour]
    // (See also examples in 'PraxisTest2.java'.)
    public String toString() {
        // TODO: implement method.
        return "";
    }

}

//TODO: Define additional class(es) if needed (either here or in a separate file).
