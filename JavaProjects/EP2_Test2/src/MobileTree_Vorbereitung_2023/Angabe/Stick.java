package MobileTree_Vorbereitung_2023.Angabe;

import java.util.NoSuchElementException;

// A 'Stick' has a specified stick weight, that can not be changed after
// initialisation. Mobiles can be attached to the stick (recursive structure).
// 'Stick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class Stick implements Mobile
{

    //TODO: define missing parts of the class.


    // Initialises 'this'; throws an 'StickBreaksException' if the sum of the weight of
    // all mobiles in the array 'attached' is greater than 10 times the 'stickWeight'.
    // The detail message of the exception is "Stick breaks!".
    // Precondition: attached.length > 0 and for any two mobiles m1 and m2 being part of
    // 'attached' (including sub-mobiles) it holds that m1.equals(m2) == false, this is,
    // that there are no duplicates anywhere in a mobile.
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {

    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' if this mobile
    // is directly attached to this stick (no recursive search). In this case 'true' is returned.
    // Otherwise, the call of this method has no effect and 'false' is returned.
    // Throws a 'StickBreaksException' if the replacement would violate the
    // condition that the sum of the weight of all attached mobiles has to be
    // less than or equal to 10 times its stick weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {
        return false;
    }


    @Override
    public int getWeight() {
        return 0;
    }

    // Returns 'true' if 'o' is also of class 'Stick', has an equal stick weight, and has equal mobiles
    // attached, regardless of their order. This means that 'this' and 'o' have the same number of mobiles
    // attached and every mobile attached to 'this' is equal to a mobile attached to 'o' (and vice versa).
    // Otherwise, 'false' is returned.
    public boolean equals(Object o) {
        return false;
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

