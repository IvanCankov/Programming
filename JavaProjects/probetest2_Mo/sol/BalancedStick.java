import java.util.Objects;

// A 'BalancedStick' has a specified stick weight, that can not be changed after
// initialisation. On the left and right end of the stick mobiles
// are attached (recursive structure). 'BalancedStick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class BalancedStick implements Mobile
{

    private int myStickWeight;
    private Mobile left;
    private Mobile right;

    // Initialises 'this'; throws an 'UnbalancedException' if the resulting mobile
    // would not be balanced, i.e. if left.getWeight() != right.getWeight(). The detail message
    // of the exception contains information about the difference between left and right weight,
    // for example "Stick unbalanced (left 7 - right 16)" (see example in 'PraxisTest2.java').
    // Preconditions: stickWeight > 0, left != null, right != null, left != right,
    // no part of a mobile has the same identity as another part.
    public BalancedStick(int stickWeight, Mobile left, Mobile right) throws UnbalancedException {

        this.myStickWeight = stickWeight;
        this.left = left;
        this.right = right;

        if(left.getWeight() != right.getWeight()){
            throw new UnbalancedException("Stick unbalanced (left " + left.getWeight() + " - " + "right " + right.getWeight() + ")");
        }
    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' and
    // returns 'true' if such a mobile is contained as part of this mobile, i.e., attached to this
    // stick or below (recursive search). Otherwise, the call of this method has no effect and
    // 'false' is returned.
    // Throws an 'UnbalancedException' if the replacement would violate the
    // condit StarIterator myIterator = new BalancedStcikIterator(this);
    //        while(myIterator.hasNext()){
    //            if(toReplace )
    //        }ions that all sticks need to be balanced. The detail message
    // of the exception contains information about the difference between left and right weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws UnbalancedException {

        if(this.getLeft().equals(toReplace)){
            this.left = replaceWith;
            return true;
        } else if (this.getRight().equals(toReplace)){
            this.right = replaceWith;
            return true;
        }

        if(this.getLeft() instanceof BalancedStick){
            return ((BalancedStick)this.getLeft()).replace(toReplace,replaceWith);
        }

        if(this.getRight() instanceof BalancedStick){
            return ((BalancedStick)this.getRight()).replace(toReplace,replaceWith);
        }

        return false;


    }

    @Override
    public int getWeight() {
        return this.myStickWeight + this.left.getWeight()+this.right.getWeight();
    }



    @Override
    // Two sticks are equal if
    // 1.) they have the same stick weight and
    // 2.) if the left part of 'this' equals the left part of 'o' and the right part of 'this'
    //       equals the right part of 'o'
    //     or
    //     if the right part of 'this' equals the left part of 'o' and the left part of 'this'
    //       equals the right part of 'o' (i.e., exchanging left and right part does not
    //       change the value returned by 'equals').
    //
    // For example, all three of the following mobiles are equal (provided that corresponding
    // objects of Star are equal):
    //
    //          |                      |                |
    //      +---2---+              +---2---+        +---2---+
    //      |       |              |       |        |       |
    //   +--2--+    *           +--2--+    *        *    +--2--+
    //   |     |    16          |     |    16       16   |     |
    //   *  +--1--+          +--1--+  *               +--1--+  *
    //   7  |     |          |     |  7               |     |  7
    //      *     *          *     *                  *     *
    //      3     3          3     3                  3     3
    //
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalancedStick stars = (BalancedStick) o;
        return myStickWeight == stars.myStickWeight &&
                (this.left.equals(stars.left) && this.right.equals(stars.right)
                ||(this.left.equals(stars.right) && this.right.equals(stars.left)));
    }


    // Returns a 'StarSet' view of 'this', containing all stars of this mobile.
    // Later changes in 'this' will be reflected in the returned view.
    @Override
    public StarCollection getStarCollection() {
        return new myStarCollection(this);
    }

    public boolean contains(Star s){

        if(this.getLeft().equals(s)){
            return true;
        } else if (this.getRight().equals(s)){
            return true;
        }

        if(this.getLeft() instanceof BalancedStick){
            return ((BalancedStick)this.getLeft()).contains(s);
        }

        if(this.getRight() instanceof BalancedStick){
            return ((BalancedStick)this.getRight()).contains(s);
        }

        return false;

    }

    @Override
    public StarIterator iterator() {
        return new BalancedStcikIterator(this);
    }

    public Mobile getLeft(){
        return this.left;
    }

    public Mobile getRight() {
        return right;
    }

    @Override
    public String toString(){

        String s = "-" + this.myStickWeight + "-";
        if(this.left != null){
            s = "(" +this.left.toString() +")" + s;
        }

        if(this.right != null){
            s+= "(" + this.right.toString() + ")";
        }
        return s;
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
