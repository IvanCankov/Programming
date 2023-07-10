package _2022_Gruppe1130.Lösung;

import java.util.*;

// A more complex recipe consisting of multiple objects of type 'recipe'. The order is relevant.
// 'Gruppe1130.ComplexRecipe' is subtype of 'Gruppe1130.Recipe'.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class ComplexRecipe  implements Recipe{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that set or return just the value of a variable).
    private List<Recipe> list = new ArrayList<>();


    // Initializes 'this' with recipes in the specified order.
    // Precondition: recipes != null, recipes.length > 1
    public ComplexRecipe(Recipe... recipes) {
        // TODO: implement constructor.
        for (int i = 0; i < recipes.length; i++) {
            list.add(recipes[i]);
        }
    }

    //@Override
    // Returns an iterator over elements of 'Gruppe1130.Gruppe1300.Ingredient', where the
    // iterations are in the order of the recipes specified at initialization
    // of 'this'.
    // The iterator's 'next()' method throws a 'java.util.NoSuchElementException'
    // with the message "no next recipe!" of the iteration has no more elements.
    public IngredientIterator iterator() {
        // TODO: implement method.
        Iterator<Recipe> iter = list.iterator();
        return new IngredientIterator() {
            private IngredientIterator iter2 = iter.next().iterator();
            @Override
            public Ingredient next() {
                if(!hasNext()) throw new NoSuchElementException("no next recipe!");
                if(iter2.hasNext()) return iter2.next();
                iter2=iter.next().iterator();
                return iter2.next();
            }
            @Override
            public boolean hasNext() {
                return iter.hasNext() || iter2.hasNext();
            }
        };
    }

    @Override
    // Returns a readable representation with all the recipe components of 'this' in the
    // order specified at initialization of 'this'.
    // The format is reflecting the structure of the recipe and is shown in the following
    // example:
    // [{Gruppe1130.Gruppe1300.Egg=50, Gruppe1130.Gruppe1300.Flour=300, Gruppe1130.Gruppe1300.Milk=250}, {Gruppe1130.Gruppe1300.Egg=100}]
    // (See also examples in 'Gruppe1130.Gruppe1300.Gruppe1600.PraxisTest2.java'.)
    //
    public String toString() {
        // TODO: implement method.
        Iterator<Recipe>  iter = list.iterator();
        String ret = "[";
        while (iter.hasNext()){
            ret+=iter.next().toString()+", ";
        }
       ret = ret.substring(0,ret.length()-2);
        ret+="]";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexRecipe that = (ComplexRecipe) o;

        return Objects.equals(list, that.list);
    }



    @Override
    public int getQuantityOf(Ingredient ingredient) {
        Iterator<Recipe>  iter = list.iterator();
        int ret = 0;
        while (iter.hasNext()){
            ret += iter.next().getQuantityOf(ingredient);
        }
        return ret;
    }
}

//TODO: Define additional class(es) if needed (either here or in a separate file).