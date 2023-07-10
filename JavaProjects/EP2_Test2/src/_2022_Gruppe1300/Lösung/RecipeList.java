package _2022_Gruppe1300.Lösung;

import java.util.*;

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
public class RecipeList implements Recipe{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

    //TODO: README: Keine Ahnung ob das so gemeint ist, sonst einfach  List<Recipe> vom Java-Collection framework verwenden.
    private Recipe data;
    private RecipeList next;

    // Initializes 'this' with recipes in the specified order.
    // Precondition: recipes != null, recipes.length > 0
    public RecipeList(Recipe... recipes) {
        // TODO: implement constructor.
        for (int i = 0; i < recipes.length; i++) {
            this.add(recipes[i]);
        }
    }

    // Adds a recipe at the end of this list.
    // Precondition: toAdd != null.
    public void add(Recipe toAdd) {
        // TODO: implement method.
        if(data==null) data= toAdd;
        else if(next==null) next=new RecipeList(toAdd);
        else if(next!=null) next.add(toAdd);
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    // Returns a ShoppingMap view of 'this'. Later changes in 'this' will be
    // reflected in the returned view.
    public ShoppingMap getShoppingMap() {
        // TODO: implement method.
        RecipeList sos = this;
        return new ShoppingMap() {
            @Override
            public int hashCode() {
                return sos.hashCode();
            }


            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;

                String obj1 =  obj.toString();
                Map<Ingredient, Integer> thisMap = new LinkedHashMap<>();
                for (Ingredient i:sos) {
                    if(thisMap.containsKey(i))thisMap.put(i, thisMap.get(i).intValue()+1);
                    else thisMap.put(i, 1);
                }
                Iterator<Ingredient> iter = thisMap.keySet().iterator();
                while (iter.hasNext()){
                    Ingredient asd = iter.next();
                    if(!obj1.contains(asd.toString()+"="+thisMap.get(asd))) return false;
                }
                return true;
            }


            @Override
            public String toString() {
                Map<Ingredient, Integer> map = new LinkedHashMap<>();
                for (Ingredient i:sos) {
                    if(map.containsKey(i))map.put(i, map.get(i).intValue()+1);
                    else map.put(i, 1);
                }
                String ret = "{";
                Iterator<Ingredient> iter = map.keySet().iterator();
                while (iter.hasNext()){
                    Ingredient i = iter.next();
                    ret+= i.toString()+"="+map.get(i)+", ";
                }
                ret = ret.substring(0, ret.length()-2)+"}";
                return ret;
            }
        };
    }




    // Returns 'true' if 'obj' is of class 'Gruppe1300.RecipeList' and contains equal recipes in
    // the same order as in 'this', i.e. 'this' and 'obj' have the same hierarchical structure.
    // Otherwise, the method returns 'false'.
    @Override
    public boolean equals(Object o) {
        // TODO: implement method.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeList doubles = (RecipeList) o;
        IngredientIterator iter = this.iterator();
        IngredientIterator iter2 = doubles.iterator();
        while (iter.hasNext() && iter2.hasNext()){
            if(iter.next()!=iter2.next()) return false;
        }
        return true;
    }

    @Override
    public int quantityOf(Ingredient ingredient) {
        int count = 0;
        for (Ingredient i:this) {
            if(i.getName()==ingredient.getName()) count++;
        }
        return count;
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
         RecipeList sos = this;
         return new IngredientIterator() {
             private RecipeList now = sos;
             private RecipeList next = sos.next;
             @Override
             public Ingredient next() {
                 if(!hasNext()) throw new NoSuchElementException();
                 if(now.data instanceof RecipeList) now = (RecipeList) now.data;
                 Ingredient ret = (Ingredient) now.data;
                 if(now.next!=null){
                     now = now.next;
                     if(now==next) next = next.next;
                 }else{
                     now=next;
                     if(next!=null) next=next.next;
                 }
                 return ret;
             }

             @Override
             public boolean hasNext() {
                 return now!=null;
             }
         };
    }

    @Override
    // Returns a readable representation with all the recipe components of 'this' in the
    // order specified at initialization of 'this'.
    // The format is reflecting the structure of the recipe and is shown in the following
    // example:
    // [[Egg, Egg], Milk, Flour]
    // (See also examples in 'PraxisTest2.java'.)
    public String toString() {
       RecipeList now = this;
       RecipeList next = this.next;
       String ret = "[";
        // TODO: implement method.
        while (now!=null){
            if(now.data instanceof RecipeList){
                ret+="[";
                now=(RecipeList) now.data;
            }
            ret+= now.data.toString();
            if(now.next!=null){
                now = now.next;
                ret+=", ";
                if(now==next) next = next.next;
            }else{
                now=next;
                if(next!=null){
                    next=next.next;
                    ret+="], ";
                }
            }
        }
        ret+="]";
        return ret;
    }
}

//TODO: Define additional class(es) if needed (either here or in a separate file).
