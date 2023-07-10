package MobileBT_Vorbereitung_2023.Lösung;
import java.util.NoSuchElementException;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight, that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration
{
    private final int weight ;
    //TODO: define missing parts of the class.

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public StarCollection getStarCollection() {
        Star sos = this;
        return new StarCollection() {
            @Override
            public boolean contains(Star s) {
                return sos.equals(s);
            }
        };
    }

    @Override
    public StarIterator iterator() {
        Star sos = this;
        return new StarIterator() {
            boolean called;
            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Star next() {
                if(!hasNext()) throw new NoSuchElementException("no star element!");
                called=true;
                return sos;
            }
        };
    }

    public Star(int weight) {

        // TODO: implement constructor.
        this.weight=weight;
    }

    @Override
    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        // TODO: implement method.
        return "*"+weight;
    }
}
