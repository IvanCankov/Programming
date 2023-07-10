// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight, that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration
{

    private int weight;

    public Star(int weight) {

        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        // TODO: implement method.
        return "*" + weight;
    }

    @Override
    public StarCollection getStarCollection() {
        return null;
    }

    @Override
    public StarIterator iterator() {
        return null;
    }
}
