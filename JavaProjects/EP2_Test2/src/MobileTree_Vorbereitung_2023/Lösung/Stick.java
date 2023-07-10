package MobileTree_Vorbereitung_2023.Lösung;

import java.util.*;

// A 'Stick' has a specified stick weight, that can not be changed after
// initialisation. Mobiles can be attached to the stick (recursive structure).
// 'Stick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class Stick implements Mobile
{

    //TODO: define missing parts of the class.
    private final int sWeight;
    private Mobile[] attached;


    // Initialises 'this'; throws an 'StickBreaksException' if the sum of the weight of
    // all mobiles in the array 'attached' is greater than 10 times the 'stickWeight'.
    // The detail message of the exception is "Stick breaks!".
    // Precondition: attached.length > 0 and for any two mobiles m1 and m2 being part of
    // 'attached' (including sub-mobiles) it holds that m1.equals(m2) == false, this is,
    // that there are no duplicates anywhere in a mobile.
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {
        int weight = stickWeight;
        for (Mobile stars : attached) {
            weight += stars.getWeight();
        }
        if(weight> 10*stickWeight) throw new StickBreaksException("Stick breaks!");
        this.sWeight=stickWeight;
        this.attached=attached;
    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' if this mobile
    // is directly attached to this stick (no recursive search). In this case 'true' is returned.
    // Otherwise, the call of this method has no effect and 'false' is returned.
    // Throws a 'StickBreaksException' if the replacement would violate the
    // condition that the sum of the weight of all attached mobiles has to be
    // less than or equal to 10 times its stick weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {
        for (int i = 0; i < attached.length; i++) {
            if(attached[i].equals(toReplace)){
                attached[i]=replaceWith;
                if(this.getWeight()>10*this.sWeight) throw new StickBreaksException("Stick breaks!");
                return true;
            }
        }
        return false;
    }



    // Returns 'true' if 'o' is also of class 'Stick', has an equal stick weight, and has equal mobiles
    // attached, regardless of their order. This means that 'this' and 'o' have the same number of mobiles
    // attached and every mobile attached to 'this' is equal to a mobile attached to 'o' (and vice versa).
    // Otherwise, 'false' is returned.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stick stars = (Stick) o;

        if (sWeight != stars.sWeight) return false;
        boolean check = false;
        for (int i = 0; i < attached.length; i++) {
            for (int j = 0; j < stars.attached.length; j++) {
                if(attached[i].equals(stars.attached[j])){
                    check=true;
                    break;
                }
            }
            if(!check) return false;
        }
        return true;
    }



    @Override
    public int getWeight() {
        int weight = sWeight;
        for (Mobile i:attached) {
            weight+= i.getWeight();
        }
        return weight;
    }

    public String toString() {
        String ret = sWeight+"[";
        for (int i = 0; i < attached.length; i++) {
            ret+= attached[i].toString()+", ";
        }
        ret=ret.substring(0,ret.length()-2)+"]";
        return ret;
    }


    // Returns a 'Countable' view of 'this'. The returned object counts the
    // number of sticks in this mobile.
    // Later changes in 'this' will be reflected in the returned view.
    @Override
    public Countable getStickCountable() {
        Mobile[] sos = attached;
        return new Countable() {
            @Override
            public int count() {
                int count = 1;
                for (Mobile i:sos) {
                   count += i.getStickCountable().count();
                }
                return count;
            }
        };
    }

    @Override
    public StarIterator iterator() {

       StarIterator[] sos = new StarIterator[attached.length];
        for (int i = 0; i < attached.length; i++) {
            sos[i]= attached[i].iterator();
        }
        return new StarIterator() {

            @Override
            public boolean hasNext() {
                for (int i = 0; i < sos.length; i++) {
                    if(sos[i].hasNext()) return true;
                }
                return false;
            }

            @Override
            public Star next() {
                for (int i = 0; i < sos.length; i++) {
                    if(sos[i].hasNext()) return sos[i].next();
                }
                throw new NoSuchElementException("no star element!");
            }
        };
    }
}

