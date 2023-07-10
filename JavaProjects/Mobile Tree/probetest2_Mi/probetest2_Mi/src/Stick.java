import java.util.*;

// A 'Stick' has a specified stick weight, that can not be changed after
// initialisation. Mobiles can be attached to the stick (recursive structure).
// 'Stick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class Stick implements Mobile
{

    Mobile[] mobile;

    // Initialises 'this'; throws an 'StickBreaksException' if the sum of the weight of
    // all mobiles in the array 'attached' is greater than 10 times the 'stickWeight'.
    // The detail message of the exception is "Stick breaks!".
    // Precondition: attached.length > 0 and for any two mobiles m1 and m2 being part of
    // 'attached' (including sub-mobiles) it holds that m1.equals(m2) == false, this is,
    // that there are no duplicates anywhere in a mobile.
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {
        //...
        this.mobile = attached;
    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' if this mobile
    // is directly attached to this stick (no recursive search). In this case 'true' is returned.
    // Otherwise, the call of this method has no effect and 'false' is returned.
    // Throws a 'StickBreaksException' if the replacement would violate the
    // condition that the sum of the weight of all attached mobiles has to be
    // less than or equal to 10 times its stick weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {

        // TODO: implement method.
        return false;
    }

    @Override
    public int getWeight() {
        int weight = 0;



        return 0;
    }

    @Override
    // Returns 'true' if 'o' is also of class 'Stick', has an equal stick weight, and has equal mobiles
    // attached, regardless of their order. This means that 'this' and 'o' have the same number of mobiles
    // attached and every mobile attached to 'this' is equal to a mobile attached to 'o' (and vice versa).
    // Otherwise, 'false' is returned.
    public boolean equals(Object o) {

        // TODO: implement method.
        return false;
    }

    @Override
    public Countable getStickCountable() {
        return null;
    }

    @Override
    public StarIterator iterator() {
        return new StarIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Star next() {
                return null;
            }
        };
    }
}

// TODO: define additional classes if needed (either here or in a separate file).