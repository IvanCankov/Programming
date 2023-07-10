package Gruppe1130;

// A simple recipe is an unordered mixture of ingredients;
// 'Gruppe1130.SimpleRecipe' is subtype of 'Gruppe1130.Recipe'.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class SimpleRecipe {


    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

    // Initializes 'this' as an empty recipe.
    public SimpleRecipe() {
        // TODO: implement constructor.
    }

    // Adds an ingredient with its quantity in grams to this recipe. If
    // the ingredient is already contained in 'this' with a certain quantity,
    // the specified quantity 'grams' is added to the quantity of the ingredient.
    // Precondition: ingredient != null.
    public void put(Ingredient ingredient, int grams) {
        // TODO: implement method.
    }

    // Returns a 'Gruppe1130.Scale' view of 'this'. Later changes to 'this' will be reflected in the
    // returned view.
    public Scale getScale() {
        // TODO: implement method.
        return null;
    }

    //@Override
    // Returns an iterator over all ingredients contained in 'this'.
    // The iterator's 'next()' method throws a 'java.util.NoSuchElementException'
    // with the message "no next ingredient!" if the iteration has no more elements.
    // (See examples in 'Gruppe1130.Gruppe1300.Gruppe1600.PraxisTest2.java'.)
    public IngredientIterator iterator() {
        // TODO: implement method.
        return null;
    }

    @Override
    // Returns a readable representation of 'this', with all distinct ingredients
    // and their quantity. There is no specific order. The format is shown in the
    // following example:
    // {Gruppe1130.Gruppe1300.Egg=2, Gruppe1130.Gruppe1300.Milk=1, Gruppe1130.Gruppe1300.Flour=1}
    // (See examples in 'Gruppe1130.Gruppe1300.Gruppe1600.PraxisTest2.java'.)
    public String toString() {
        // TODO: implement method.
        return "";
    }

}

//TODO: Define additional class(es) if needed (either here or in a separate file).
