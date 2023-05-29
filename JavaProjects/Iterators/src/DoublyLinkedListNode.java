import java.util.Iterator;

public class DoublyLinkedListNode{
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
    public Iterator<Point> iterator() {
        return null;
    }

    private class DLLIterator implements Iterator<ListNode> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public ListNode next() {
            return null;
        }
    }
}