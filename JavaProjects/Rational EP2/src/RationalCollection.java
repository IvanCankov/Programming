public class RationalCollection {

    private Node root;

    public RationalCollection() {

        this.root = null;
    }

    public void add(Node n) {

        if (root == null) root = n;
        else root.nodeAdd(n);
    }

    public int count(Rational r) {

        if (root == null) return 0;
        else return root.count(r);
    }

    @Override
    public String toString() {

        if (root == null) return "";
        else return root.nodeToString();
    }
}

class Node {
    private Rational value;
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
