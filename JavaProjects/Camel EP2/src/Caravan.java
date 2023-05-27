// A caravan of camels implemented as a singly linked list with entries of 'Camel'.
// There are no 'null' entries in the list.
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class Caravan {

    private Node head;

    // Initializes this caravan as an empty list.
    public Caravan() {
        head = null;
    }

    // Adds 'camel' as the last camel to the end of this caravan.
    // Precondition: camel != null.
    public void addLast(Camel camel) {
        if (this.head == null) {
            this.head = new Node(camel, null);
            return;
        }

        Node temp = this.head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(new Node(camel, null));
    }

    // Inserts a new camel into this caravan. Seen from the head of the caravan, the camel is
    // inserted just before the first camel in the caravan that has the same strength as the
    // specified 'searchStrength'. If no such camel is found, the new camel is added as the head
    // of the caravan.
    // Precondition: camel != null.
    public void insertBefore(int searchStrength, Camel camel) {
        if (this.head == null) {
            this.head = new Node(camel, null);
        }

        Node next = this.head;
        Node prev = null;
        while (next.getNext() != null) {
            prev = next;
            next = next.getNext();
            if (next.getValue().getStrength() == searchStrength) {
                prev.setNext(new Node(camel, next));
                return;
            }
        }
        this.head = new Node(camel, this.head);
    }

    // Removes 'number' camels from the front of the caravan (the first 'number'
    // camels seen from the head of the caravan) and returns them as a new caravan in which they
    // have the same order as they had in 'this' (see examples in 'PraxisTest1.java'). If this
    // caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
    // Precondition: number >= 0 && number <= this.size().
    public Caravan detachFront(int number) {

        if(head == null) {
            return new Caravan();
        }

        int i = 1;
        Node temp = this.head;

        while (i < number) {
            temp = temp.getNext();
            i++;
        }

        Caravan rCaravan = new Caravan();
        rCaravan.head = this.head;
        this.head = temp.getNext();
        temp.setNext(null);

        return rCaravan;
    }
    // Returns the number of camels in the caravan.
    public int size() {

        if (this.head == null) {
            return -1;
        }

        int size = 1;
        Node temp = this.head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    // Returns a string representation of this caravan with all its camels in brackets
    // in corresponding order with head of the caravan on the left,
    // followed by the pace of the caravan, which corresponds to the pace of
    // the slowest camel in the caravan.
    // Example: [(10-2=8), (5-2=3), (7-3=4), (10-3=7)] pace = 3
    // Returns "[]" if the caravan is empty.
    public String toString() {

        return (this.head == null) ? "[]" : "[" + head.nodeToSrting() + "]";
    }
}

class Node {
    private Camel value;
    private Node next;

    public Node(Camel value, Node next) {

        this.value = value;
        this.next = next;
    }

    public void setNext(Node next) {

        this.next = next;
    }

    public Camel getValue() {

        return this.value;
    }

    public Node getNext() {

        return this.next;
    }

    public String nodeToSrting() {
        return (this.next == null) ? "" : (this.value.toString() + ", " + this.next.nodeToSrting());
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
