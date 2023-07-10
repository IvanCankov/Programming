// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight, that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration
{

    private int myWeight;

    public Star(int weight) {

        this.myWeight = weight;
    }

    @Override
    public int getWeight() {
        return myWeight;
    }

    @Override
    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        return "*"+this.myWeight;
    }


    // Returns a 'StarSet' view of 'this', containing all stars of this mobile.
    // Later changes in 'this' will be reflected in the returned view.
    @Override
    public StarCollection getStarCollection() {
        return null;
    }

    @Override
    public StarIterator iterator() {
        return null;
    }
}
