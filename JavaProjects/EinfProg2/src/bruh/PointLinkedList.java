// A list of 2D-points (objects of type 'Point') implemented as a linked list.
// The number of elements of the list is not limited.
//
// TODO: define further classes and methods for the implementation of the linked list,
//  if needed.
//
public class PointLinkedList {
    private Node head;
    private PointLinkedList pointLinkedList;
    // Initializes 'this' as an empty list.
    public PointLinkedList() {

    }

    // Inserts the specified element 'point' at the beginning of this list.
    // Precondition: point != null.
    public void addFirst(Point point) {

        Node oldHead = this.head;
        this.head = new Node(point, oldHead);
    }

    // Appends the specified element 'point' to the end of this list.
    // Precondition: point != null.
    public void addLast(Point point) {

        if(this.head == null){
            this.head = new Node(point, null);
        } else {
            Node last = this.head;

            while(last.next() != null) {
                last = last.next();
            }
            //we set the pointer of our previous last element to our new last element
            last.setNext(new Node(point, null));
        }
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Point getLast() {

        if (this.head == null) {
            return null;
        } else {
            Node last = this.head;

            while (last.next() != null) {
                last = last.next();
            }
            return last.value();
        }
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Point getFirst() {

        if(size() == 0) return null;
        return this.head.value();
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Point pollFirst() {

        Node first = this.head;

        this.head = first.next();
        return first.value();
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Point pollLast() {

        if (this.head == null) {
            return null;
        }

        // NOTE: we got through the list until we hit the second to last element then retrieve the value of the last
        // by using .next() on last, then we set the pointer of last to null.

        Node last = this.head;
        for (int i = 0; i < size() - 2; i++) {
            last = last.next();
        }
        Point returned = last.next().value();
        last.setNext(null);
        return returned;
    }

    // Inserts the specified element 'point' at the specified position in this list.
    // Precondition: i >= 0 && i <= size() && point != null.
    public void add(int i, Point point) {

        Node nodeBeforeInsertion = this.head;

        for (int j = 0; j < i - 1; j++) {
            nodeBeforeInsertion = nodeBeforeInsertion.next();
        }
        Node nodeAfterInsertion = nodeBeforeInsertion.next();
        nodeBeforeInsertion.setNext(new Node(point, nodeAfterInsertion));
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Point get(int i) {

        if(this.head == null) return null;

        Node last = this.head;
        for (int j = 0; j < i; j++) {
            last = last.next();
        }
        return last.value();
    }

    // Returns the index of the first occurrence (element with equal coordinates to 'point') of the
    // specified element in this list, or -1 if this list does not contain the element.
    // Precondition: point != null.
    public int indexOf(Point point) {

        if (this.head == null) {
            return -1; // NOTE: returns -1 if list is not initialised
        } else {
            Node last = this.head;

            for (int index = 0; index < size(); index++) {
                if(last.value() == point) return index;
                last = last.next();
            }
            return -1; // NOTE: returns -1 if element is not int the LinkedList
        }
    }

    // Returns the number of elements in this list.
    public int size() {

        if(this.head == null) return 0;

        Node last = this.head;
        int size = 1;
        while (last.next() != null) {
            size += 1;
            last = last.next();
        }
        return size;
    }
}

// TODO: define further classes, if needed (either here or in a separate file). <3
