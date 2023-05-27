public class RationalCollection {

    private Node root;

    //Initialises this as an empty RationalCollection.
    public RationalCollection() {

        this.root = null;
    }

    public Node getRoot() {

        return root;
    }

    //Adds all rationals from rc to a new tree that are smaller than the maximum.
    public RationalCollection(RationalCollection rc, Rational maximum) {
        //TODO: implement constructor
    }

    //Adds the specified node to the collection
    public void add(Node n) {

        if (root == null) root = n;
        else root.nodeAdd(n);
    }

    //Counts how many times the specified rational occurs within the collection
    public int count(Rational r) {

        if (root == null) return 0;
        else return root.count(r);
    }

    //Returns the collection in string form
    @Override
    public String toString() {

        if (root == null) return "";
        else return root.nodeToString();
    }
}

class Node {
    private final Rational value;
    private Node left;
    private Node right;

    public Node(Rational value) {

        this.value = value;
    }

    public void nodeAdd(Node node) {

        if (this.value.compareTo(node.value) < 1) {
            if (this.left == null) this.left = node;
            else this.left.nodeAdd(node);
        } else {
            if (this.right == null) this.right = node;
            else this.right.nodeAdd(node);
        }
    }

    public int count(Rational r) {

        int count = 0;

        if (this.value.compareTo(r) == 0) count++;
        if (this.left != null) count += this.left.count(r);
        if (this.right != null) count += this.right.count(r);

        return count;
    }

    public String nodeToString() {

        return (this.left == null ? "" : this.left.nodeToString()) + this.value.toString() + ", " +
                ((this.right == null) ? "" : this.right.nodeToString());
    }
}
