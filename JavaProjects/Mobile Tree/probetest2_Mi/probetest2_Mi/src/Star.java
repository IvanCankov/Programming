// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight of type 'int', that can not be changed after
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

    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {


        return "*" + this.weight;
    }

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
        Star out = this;

        return new StarIterator() {
            private boolean called;

            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Star next() {
                called = !called;
                return out;
            }
        };
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
