package MobileBT_Vorbereitung_2023.Lösung;
import java.util.NoSuchElementException;


// A 'BalancedStick' has a specified stick weight, that can not be changed after
// initialisation. On the left and right end of the stick mobiles
// are attached (recursive structure). 'BalancedStick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class BalancedStick implements Mobile
{

    //TODO: define missing parts of the class.
    private final int weight;
    private Mobile left, right;

    // Initialises 'this'; throws an 'UnbalancedException' if the resulting mobile
    // would not be balanced, i.e. if left.getWeight() != right.getWeight(). The detail message
    // of the exception contains information about the difference between left and right weight,
    // for example "Stick unbalanced (left 7 - right 16)" (see example in 'PraxisTest2.java').
    // Preconditions: stickWeight > 0, left != null, right != null, left != right,
    // no part of a mobile has the same identity as another part.
    public BalancedStick(int stickWeight, Mobile left, Mobile right) throws UnbalancedException {
        if(left.getWeight()!=right.getWeight()) throw new UnbalancedException("Stick unbalanced (left "+ left.getWeight()+" - "+"right "+ right.getWeight()+")");
        weight=stickWeight;
        this.left=left;
        this.right=right;

        // TODO: implement constructor.
    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' and
    // returns 'true' if such a mobile is contained as part of this mobile, i.e., attached to this
    // stick or below (recursive search). Otherwise, the call of this method has no effect and
    // 'false' is returned.
    // Throws an 'UnbalancedException' if the replacement would violate the
    // conditions that all sticks need to be balanced. The detail message
    // of the exception contains information about the difference between left and right weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws UnbalancedException {

        // TODO: implement method.
        boolean ret = false;
        if(left.equals(toReplace)) {
            ret = true;
            left = replaceWith;
            if(left.getWeight()!=right.getWeight()) throw new UnbalancedException("Stick unbalanced (left "+ left.getWeight()+" - "+"right "+ right.getWeight()+")");
        }
        if(right.equals(toReplace))  {
            right=replaceWith;
            ret = true;
            if(left.getWeight()!=right.getWeight()) throw new UnbalancedException("Stick unbalanced (left "+ left.getWeight()+" - "+"right "+ right.getWeight()+")");
        }
        if(left instanceof BalancedStick)  return ((BalancedStick) left).replace(toReplace,replaceWith);
        if(right instanceof BalancedStick) return ((BalancedStick) right).replace(toReplace,replaceWith);
        return ret;
    }

    @Override
    public int getWeight() {
        return left.getWeight()+ weight+ right.getWeight();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalancedStick stars = (BalancedStick) o;
        boolean weight = this.weight==stars.weight;
        boolean left = this.left.equals(((BalancedStick) o).left) &&  this.right.equals(((BalancedStick) o).right);
        boolean right = this.right.equals(((BalancedStick) o).left) && ((BalancedStick) o).left.equals(this.right);
        return weight && (left || right);
    }


    @Override
    public StarCollection getStarCollection() {
        BalancedStick sos = this;
        return new StarCollection() {
            @Override
            public boolean contains(Star s) {
                for (Star i:sos) {
                    if(i.equals(s)) return true;
                }
                return false;
            }
        };
    }

    @Override
    public StarIterator iterator() {
        StarIterator left = this.left.iterator();
        StarIterator right = this.right.iterator();

        return new StarIterator() {
            @Override
            public boolean hasNext() {
                return left.hasNext() || right.hasNext();
            }

            @Override
            public Star next() {
                if(!hasNext())throw new NoSuchElementException("no star element!");
                if(left.hasNext()) return left.next();
                else return right.next();
            }
        };
    }

    @Override
    public String toString() {
        return "("+ left.toString() + ")-"+weight+"-("+ right.toString()+ ")";
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
