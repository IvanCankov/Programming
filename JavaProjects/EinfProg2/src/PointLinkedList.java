import java.util.Iterator;

// A list of 2D-points (objects of type 'Point') implemented as a linked list.
// The number of elements of the list is not limited.
//
// TODO: define further classes and methods for the implementation of the linked list,
//  if needed.
//
public class PointLinkedList implements Iterable<Point> {

    private MyListNode head;
    private MyListNode last;
    private int size;

    // Initializes 'this' as an empty list.
    public PointLinkedList() {
        this.size = 0;
    }

    // Inserts the specified element 'point' at the beginning of this list.
    // Precondition: point != null.
    public void addFirst(Point point) {

        if (head == null) {
            head = new MyListNode(point, null);
            last = head;
        } else if (head == last) {
            head = new MyListNode(point, last);
        } else {
            head = new MyListNode(point, head);
        }
        size += 1;
    }

    // Appends the specified element 'point' to the end of this list.
    // Precondition: point != null.
    public void addLast(Point point) {

        if (head == null) {
            head = new MyListNode(point, null);
            last = head;

        } else if (head == last) {
            last = new MyListNode(point, null);
            head.setNext(last);


        } else {
            MyListNode toBeAdded = new MyListNode(point, null);
            last.setNext(toBeAdded);
            last = toBeAdded;
        }

        size += 1;
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Point getLast() {
        return (head != null) ? last.getValue() : null;
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Point getFirst() {
        return (head != null) ? head.getValue() : null;
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Point pollFirst() {

        if (head == null) {
            return null;
        }

        Point p = head.getValue();
        head = head.getNext();

        if (head == null) {
            last = null;
        }
        size -= 1;

        return p;
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Point pollLast() {
        if (head == null) {
            return null;
        }

        Point result = last.getValue();
        size -= 1;

        if (head == last) {
            head = last = null;
        } else {
            MyListNode current = head;
            while (current.getNext() != last) {
                current = current.getNext();
            }

            last = current;
            last.setNext(null);
        }

        return result;
    }



    // Inserts the specified element 'point' at the specified position in this list.
    // Precondition: i >= 0 && i <= size() && point != null.
    public void add(int index, Point point) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            addFirst(point);
        } else {
            MyListNode toBeAdded = new MyListNode(point, null);
            MyListNode current = head;

            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }

            toBeAdded.setNext(current.getNext());
            current.setNext(toBeAdded);

            if (current == last) {
                last = toBeAdded;
            }

            size += 1;
        }
    }


    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Point get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        MyListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }


    // Returns the index of the first occurrence (element with equal coordinates to 'point') of the
    // specified element in this list, or -1 if this list does not contain the element.
    // Precondition: point != null.
    public int indexOf(Point point) {
        MyListNode current = head;
        int index = 0;

        while (current != null) {
            if (current.getValue().compareTo(point) == 0) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    // Returns the number of elements in this list.
    public int size() {
        return this.size;
    }

    private class PointIterator implements Iterator<Point> {
        private MyListNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Point next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in the list.");
            }

            Point value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    @Override
    public Iterator<Point> iterator() {
        return new PointIterator();
    }

}

// TODO: define further classes, if needed (either here or in a separate file).
