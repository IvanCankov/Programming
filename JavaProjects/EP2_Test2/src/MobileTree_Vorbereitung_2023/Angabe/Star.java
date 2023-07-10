package MobileTree_Vorbereitung_2023.Angabe;

import java.util.NoSuchElementException;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight of type 'int', that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration
{

    //TODO: define missing parts of the class.



    public Star(int weight) {

    }


    @Override
    public int getWeight() {
        return 0;
    }

    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        // TODO: implement method.
        return "";
    }

    // Returns a 'Countable' view of 'this'. The returned object counts the
    // number of sticks in this mobile.
    // Later changes in 'this' will be reflected in the returned view.
    @Override
    public Countable getStickCountable() {
       return null;
    }

    @Override
    public StarIterator iterator() {
        return null;
    }

}

// TODO: define additional classes if needed (either here or in a separate file).

