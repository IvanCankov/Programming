import java.util.Iterator;

public class DoublyLinkedListNode{

    DoublyLinkedListNode next;
    DoublyLinkedListNode previous;
    Point value;

    public DoublyLinkedListNode(Point point) {
        this.value = point;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public DoublyLinkedListNode getPrevious() {
        return previous;
    }

    public Point getValue() {
        return value;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public void setPrevious(DoublyLinkedListNode previous) {
        this.previous = previous;
    }
}
class DoublyLinkedList implements Iterable<Point>, List {

    @Override
    public void add(ListNode node) {

    }

    @Override
    public void push(Point point) {

    }

    @Override
    public Point pop() {
        return null;
    }

    @Override
    public void remove(Point point) {

    }

    @Override
    public Iterator<DoublyLinkedListNode> iterator() { // what the fuck

        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<DoublyLinkedListNode> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public DoublyLinkedListNode next() {
            return null;
        }
    }
}