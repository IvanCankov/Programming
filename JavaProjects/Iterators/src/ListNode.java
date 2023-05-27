import java.awt.*;
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

        return (this.value.toString() + ": " + this.getValue().getColor());
    }
}

class LinkedList implements Iterable<ListNode> {

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
