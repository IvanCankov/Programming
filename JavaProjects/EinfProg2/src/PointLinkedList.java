// A list of 2D-points (objects of type 'Point') implemented as a linked list.
// The number of elements of the list is not limited.
//
// TODO: define further classes and methods for the implementation of the linked list,
//  if needed.
//
public class PointLinkedList {

    MyListNode head;
    MyListNode last;

    // Initializes 'this' as an empty list.
    public PointLinkedList() {

        this.head = this.last = null;
    }

    // Inserts the specified element 'point' at the beginning of this list.
    // Precondition: point != null.
    public void addFirst(Point point) {

        if (head == null) {
            head = new MyListNode(point, null);
            last = head;

        } else if (head == last) {
            MyListNode buffer = last;
            MyListNode toBeAdded = new MyListNode(point, last);
            head = toBeAdded;
            last = buffer;


        } else {
            MyListNode toBeAdded = new MyListNode(point, head);
            head = toBeAdded;
        }
    }

    // Appends the specified element 'point' to the end of this list.
    // Precondition: point != null.
    public void addLast(Point point) {

        if (head == null) {
            head = new MyListNode(point, null);
            last = head;

        } else if (head == last) {
            MyListNode buffer = head;
            MyListNode toBeAdded = new MyListNode(point, null);
            last = toBeAdded;
            head = buffer;
            head.setNext(last);


        } else {
            MyListNode toBeAdded = new MyListNode(point, null);
            last.setNext(toBeAdded);
            last = toBeAdded;
        }
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Point getLast() {

        if (head != null) {
            return last.getValue();
        }

        return null;

    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Point getFirst() {

        if (head != null) {
            return head.getValue();
        }

        return null;
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Point pollFirst() {

        if (head == null) {
            return null;

        } else if (head == last) {
            Point result = head.getValue();
            head = last = null;
            return result;

        } else {
            Point result = head.getValue();
            head = head.getNext();
            return result;
        }
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Point pollLast() {
        if (head == null) {
            return null;

        } else if (head == last) {
            Point result = head.getValue();
            head = last = null;
            return result;

        } else {
            Point result = last.getValue();
            MyListNode current = this.head;
            while (current.getNext() != last) {
                current.getNext();
            }

            last = current;
            last.setNext(null);
            return result;
        }
    }

    // Inserts the specified element 'point' at the specified position in this list.
    // Precondition: i >= 0 && i <= size() && point != null.
    public void add(int i, Point point) {

        if (i > 0) {
            for (MyListNode n = this.head; n != null; n = n.getNext()) {
                if (--i == 0) {
                    MyListNode toBeAdded = new MyListNode(point, null);

                    if (n == last) {
                        n.setNext(toBeAdded);
                        last = toBeAdded;
                    } else {
                        toBeAdded.setNext(n.getNext());
                        n.setNext(toBeAdded);
                    }


                }
            }
        } else if (i == 0) {
            this.addFirst(point);
        }
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Point get(int i) {

        if (head == null) {
            return null;
        }
        if (i > 0) {
            for (MyListNode n = this.head; n != null; n = n.getNext()) {
                if (i == 0) {
                    return n.getValue();
                }
                --i;
            }
        } else if (i == 0) {
            return this.getFirst();
        }

        return null;
    }

    // Returns the index of the first occurrence (element with equal coordinates to 'point') of the
    // specified element in this list, or -1 if this list does not contain the element.
    // Precondition: point != null.
    public int indexOf(Point point) {


        if (head == null) {
            return -1;
        }
        int i = 0;
        for (MyListNode n = this.head; n != null; n = n.getNext()) {
            if (n.getValue().compareTo(point) == 0) {
                return i;
            }
            ++i;
        }

        return i;
    }

    // Returns the number of elements in this list.
    public int size() {

        if (head == null) {
            return 0;
        }
        int i = 0;
        for (MyListNode n = this.head; n != null; n = n.getNext()) {
            ++i;
        }

        return i;

    }
}

// TODO: define further classes, if needed (either here or in a separate file).
