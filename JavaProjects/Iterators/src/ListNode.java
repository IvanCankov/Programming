public class ListNode {

    private ListNode next;
    private Point value;

    public ListNode(Point p) {
        this.value = p;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }

    public ListNode getNext() {
        return next;
    }

    public Point getValue() {
        return value;
    }

    public void add(ListNode node) {

        if (this.value.equals(node.value)) this.value = node.value;
        else if (this.getNext() == null) this.setNext(node);
        else this.getNext().add(node);
    }
    
    @Override
    public String toString() {
        return this.next != null ? (this.value.toString() + ", " + this.next.toString()) : this.value.toString();
    }
}

class LinkedList {

    private ListNode root;

    public LinkedList() {
        this.root = null;
    }

    public void add(ListNode node) {

        if (root == null) this.root = node;
        else root.add(node);
    }

    @Override
    public String toString() {

        if (root == null) return "";
        else return root.toString();
    }
}
