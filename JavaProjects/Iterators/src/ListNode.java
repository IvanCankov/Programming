import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a node in a singly linked list
 */
public class ListNode {

    private ListNode next;
    private Point value;

    /**
     * Constructs a new ListNode with the specified Point as the value
     *
     * @param p the Point value for this node
     */
    public ListNode(Point p) {

        this.value = p;
    }

    /**
     * Sets the next parameter of this node
     *
     * @param node is the value that we wish to set next to
     */
    public void setNext(ListNode node) {

        this.next = node;
    }

    /**
     * Returns next of this node
     *
     * @return this.next
     */
    public ListNode getNext() {

        return next;
    }

    /**
     * Returns the value of this node
     *
     * @return this.value
     */
    public Point getValue() {

        return value;
    }

    /**
     * Adds a specified node to this and consequently other nodes
     *
     * @param node is the value that will be added to the nodes
     */
    public void add(ListNode node) {

        if (this.value.equals(node.value)) this.value = node.value;
        else if (this.getNext() == null) this.setNext(node);
        else this.getNext().add(node);
    }

    public void remove(Point point) {

        if (this.next == null) return;
        else if (this.next.value.equals(point)) this.setNext(this.next.next);
        else this.next.remove(point);
    }

    /**
     *
     * @return the string representation of this node
     */
    @Override
    public String toString() {

        return (this.value.toString() + ": " + this.getValue().getColor());
    }
}

class LinkedList implements Iterable<ListNode> {

    private ListNode root;

    /**
     * Creates a new empty linked list
     */
    public LinkedList() {

        this.root = null;
    }

    /**
     *
     * @param node adds the specified node to the list
     */
    public void add(ListNode node) {

        if (root == null) this.root = node;
        else root.add(node);
    }

    public void push(ListNode node) {

        if (this.root != null) node.setNext(root);
        this.root = node;
    }

    /**
     * Removes the specified Point point from the list
     * @param point is the point you wish to remove, if the value does not exist the function does nothing
     */
    public void remove(Point point) {
        
        if (this.root == null) return;
        if (this.root.getValue().equals(point)) this.root = this.root.getNext();
        else this.root.remove(point);
    }

    /**
     *
     * @return the string representation of this linked list using an iterator
     */
    @Override
    public String toString() {

        if (root == null) return "";
        StringBuilder returned = new StringBuilder();
        for (ListNode ln : this) {
            if (ln.getNext() != null) returned.append(ln).append(", ");
            else returned.append(ln);
        }
        return returned.toString();
    }

    @Override
    public Iterator<ListNode> iterator() {

        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<ListNode> {

        private ListNode current;

        public SLLIterator() {

            this.current = root;
        }
        @Override
        public boolean hasNext() {

            return current != null;
        }

        @Override
        public ListNode next() {

            if (!hasNext()) throw new NoSuchElementException("No more elements in the list");
            ListNode value = current;
            current = current.getNext();
            return value;
        }
    }
}
