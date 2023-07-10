package Gruppe1300;

// Represents a single basic ingredient
// (which represents the simplest form of a recipe).
// Please, do not change this interface definition.
//
public interface Ingredient extends Recipe {

    // Helper method: returns 'true' if 'i1' and 'i2' are of the same class and
    // are both of type 'Gruppe1300.Ingredient' and have the same name.
    static boolean equals(Object i1, Object i2) {

        return i1 != null && i2 != null &&
                i1.getClass() == i2.getClass() &&
                ((Ingredient)i1).getName().equals(((Ingredient)i2).getName());
    }

    // Helper method: computes the hash code of the specified ingredient.
    static int hashCode(Ingredient i) {

        return i.getName().hashCode();
    }

    // Return 'true' if 'obj' != null and 'obj' is of the same class as 'this' and
    // both objects have the same name.
    boolean equals(Object obj);

    // Returns the hash code of 'this'.
    int hashCode();

    // Returns the name of the ingredient.
    String toString();

    // Returns the name of the ingredient.
    default String getName() {

        return this.getClass().getName();
    }

    // default implementations for methods of 'Gruppe1300.Recipe'.
    // Precondition: ingredient != null.
    default int quantityOf(Ingredient ingredient) {

        return this.equals(ingredient) ? 1 : 0;
    }

    default IngredientIterator iterator() {
        return new IngredientIterator() {

            private boolean consumed = false;

            @Override
            public Ingredient next() {
                consumed = true;
                return Ingredient.this;
            }

            @Override
            public boolean hasNext() {
                return !consumed;
            }
        };
    }
}
