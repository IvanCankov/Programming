package MobileTree_Vorbereitung_2023.Lösung;

import java.util.NoSuchElementException;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight of type 'int', that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration
{

    //TODO: define missing parts of the class.

    private final int weight;

    public Star(int weight) {
        this.weight = weight;
    }


    @Override
    public int getWeight() {
        return weight;
    }

    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        // TODO: implement method.
        return "*"+weight;
    }

    // Returns a 'Countable' view of 'this'. The returned object counts the
    // number of sticks in this mobile.
    // Later changes in 'this' will be reflected in the returned view.
    @Override
    public Countable getStickCountable() {
        return new Countable() {
            @Override
            public int count() {
                return 0;
            }
        };
    }

    @Override
    public StarIterator iterator() {
        Star sos = this;
        return new StarIterator() {
            private boolean called;
            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Star next() {
                if (!hasNext()) throw new NoSuchElementException("no star element!");
                called=true;
                return sos;
            }
        };
    }


}

// TODO: define additional classes if needed (either here or in a separate file).

