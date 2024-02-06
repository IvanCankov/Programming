// A list of objects of 'RasterRGBA' implemented as a doubly linked list.
// The number of elements of the list is not limited. Entries of 'null' are allowed.
//
// TODO: define further classes and methods for the implementation of the doubly linked list, if
//  needed.
//
public class LinkedListRasterRGBA {

    private MyDoubleLinkedList head;
    private MyDoubleLinkedList tail;
    int size;

    // Initializes 'this' as an empty list.
    public LinkedListRasterRGBA() {this.size = 0;}

    public MyDoubleLinkedList getHead() {
        return head;
    }

    public MyDoubleLinkedList getTail() {
        return tail;
    }

    // Inserts the specified element 'raster' at the beginning of this list.
    public void addFirst(RasterRGBA raster) {
        MyDoubleLinkedList newHead = new MyDoubleLinkedList(raster);
        newHead.setNext(head);

        if (head == null) {
            this.head = this.tail = newHead;
        } else {
            head.setPrevious(newHead);
            this.head = newHead;
        }

        this.size++;
    }


    // Appends the specified element 'raster' to the end of this list.
    public void addLast(RasterRGBA raster) {
        MyDoubleLinkedList newTail = new MyDoubleLinkedList(raster);
        newTail.setPrevious(tail);

        if (head == null) {
            this.head = this.tail = newTail;
        } else {
            tail.setNext(newTail);
            this.tail = newTail;
        }

        this.size++;
    }


    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA getLast() {

        return (this.head == null) ? null : this.tail.getValue();
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA getFirst() {

        return (this.head == null) ? null : this.head.getValue();
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA pollFirst() {
        if (head == null) {
            return null;
        }

        RasterRGBA result = head.getValue();
        head = head.getNext();

        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }

        size--;
        return result;
    }


    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA pollLast() {
        if (head == null) {
            return null;
        }

        RasterRGBA result = tail.getValue();
        tail = tail.getPrevious();

        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }

        size--;
        return result;
    }


    // Inserts the specified element 'raster' at the specified position in this list.
    // More specifically, 'raster' is inserted as follows:
    // before insertion elements have indices from 0 to size()-1;
    // 'raster' is inserted immediately before the element with the given index 'i' (or as last
    // element if 'i == size()') such that 'raster' can be found at index 'i' after insertion.
    // Precondition: i >= 0 && i <= size().
    public void add(int index, RasterRGBA raster) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        MyDoubleLinkedList newNode = new MyDoubleLinkedList(raster);

        if (index == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrevious(newNode);
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            MyDoubleLinkedList current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            newNode.setPrevious(current);

            if (current.getNext() != null) {
                current.getNext().setPrevious(newNode);
            } else {
                tail = newNode;
            }

            current.setNext(newNode);
        }

        size++;
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public RasterRGBA get(int index) {
        if (index < 0 || index >= size) {
            return null;  // Index out of bounds
        }

        MyDoubleLinkedList current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }


    // Replaces the element at the specified position in this list with the specified element.
    // Returns the element that was replaced.
    // Precondition: i >= 0 && i < size().
    public RasterRGBA set(int index, RasterRGBA raster) {
        MyDoubleLinkedList current = head;

        for (int i = 0; i < index && current != null; i++) {
            current = current.getNext();
        }

        if (current != null) {
            RasterRGBA result = current.getValue();
            current.setValue(raster);
            return result;
        }

        return null;
    }


    // Removes the element at the specified position in this list. Shifts any subsequent
    // elements to the left (subtracts one from their indices). Returns the element that was
    // removed from the list.
    // Precondition: i >= 0 && i < size().
    public RasterRGBA remove(int index) {
        if (index < 0 || index >= size) {
            return null;  // Index out of bounds
        }

        if (index == 0) {
            RasterRGBA result = head.getValue();
            pollFirst();
            return result;
        }

        MyDoubleLinkedList current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        RasterRGBA result;
        if (current.getNext() == tail) {
            result = pollLast();
        } else {
            result = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            if (current.getNext() != null) {
                current.getNext().setPrevious(current);
            }
            size--;
        }

        return result;
    }

    // Returns the index of the last occurrence of 'raster' in this list (the highest index with an
    // element equal to 'raster'), or -1 if this list does not contain the element.
    // Equality of elements is determined by object identity (== operator).
    public int lastIndexOf(RasterRGBA raster) {
        MyDoubleLinkedList current = tail;
        int index = size - 1;

        while (current != null) {
            if (current.getValue().equals(raster)) {
                return index;
            }
            current = current.getPrevious();
            index--;
        }

        return -1;
    }

    public RasterRGBA getFromEnd(int indexFromEnd) {
        if (indexFromEnd < 0 || indexFromEnd >= size) {
            return null;  // Index out of bounds
        }

        MyDoubleLinkedList current = tail;

        for (int i = size - 1; i > indexFromEnd; i--) {
            current = current.getPrevious();
        }

        return current.getValue();
    }


    // Returns the number of elements in this list.
    public int size() {
        return size;
    }

    //TODO (optional): add more operations (e.g., floodfill).
}

// TODO: define further classes, if needed (either here or in a separate file).
