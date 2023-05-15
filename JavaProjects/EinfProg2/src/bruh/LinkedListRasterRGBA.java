// A list of objects of 'RasterRGBA' implemented as a doubly linked list.
// The number of elements of the list is not limited. Entries of 'null' are allowed.
//
// TODO: define further classes and methods for the implementation of the doubly linked list, if
//  needed.
//
public class LinkedListRasterRGBA {

    doubleLinkedList head;
    doubleLinkedList tail;

    int size;


    // Initializes 'this' as an empty list.
    public LinkedListRasterRGBA() {

        this.head = this.tail = null;
    }

    // Inserts the specified element 'raster' at the beginning of this list.
    public void addFirst(RasterRGBA raster) {

        if(head == null) {
            this.head = this.tail = new doubleLinkedList(raster,null,null);
            this.size++;
        } else if (this.head == this.tail){
            doubleLinkedList newHead= new doubleLinkedList(raster,tail,null);
            this.head = newHead;
            this.tail.setPrevious(newHead);
            this.size++;
        } else {
            doubleLinkedList newHead = new doubleLinkedList(raster,head,null);
            this.head.setPrevious(newHead);
            this.head=newHead;
            this.size++;
        }
    }

    // Appends the specified element 'raster' to the end of this list.
    public void addLast(RasterRGBA raster) {

        if(head == null) {
            this.head = this.tail = new doubleLinkedList(raster,null,null);
            this.size++;
        } else if (this.head == this.tail){
            doubleLinkedList newTail= new doubleLinkedList(raster,null,tail);
            this.tail = newTail;
            this.head.setNext(newTail);
            this.size++;
        } else {
            doubleLinkedList newTail = new doubleLinkedList(raster,null,tail);
            this.tail.setNext(newTail);
            this.tail = newTail;
            this.size++;
        }
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA getLast() {

        if(this.head == null){
            return null;
        }
        return this.tail.getValue();
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA getFirst() {

        if(this.head == null){
            return null;
        }
        return this.head.getValue();
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA pollFirst() {

        if(this.head == null){
            return null;
        } else if (this.head == this.tail){
            RasterRGBA result = this.head.getValue();
            this.head = this.tail = null;
            this.size = 0;
            return result;
        } else {
            RasterRGBA result = this.head.getValue();
            this.head = this.head.getNext();
            this.head.setPrevious(null);
            this.size--;
            return result;

        }
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public RasterRGBA pollLast() {

        if(this.head == null){
            return null;
        } else if(this.head == this.tail){
            RasterRGBA result = this.head.getValue();
            this.head = this.tail = null;
            this.size = 0;
            return result;
        } else {
            RasterRGBA result = this.tail.getValue();
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
            return result;
        }
    }

    // Inserts the specified element 'raster' at the specified position in this list.
    // More specifically, 'raster' is inserted as follows:
    // before insertion elements have indices from 0 to size()-1;
    // 'raster' is inserted immediately before the element with the given index 'i' (or as last
    // element if 'i == size()') such that 'raster' can be found at index 'i' after insertion.
    // Precondition: i >= 0 && i <= size().
    public void add(int i, RasterRGBA raster) {

        if(i == 0){
            this.addFirst(raster);
        } else {
            for(doubleLinkedList n = this.head; n != null; n = n.getNext()){
                if(--i == 0){
                    if(n == this.tail){
                        addLast(raster);
                    } else {
                        doubleLinkedList result = new doubleLinkedList(raster,null,n);
                        n.getNext().setPrevious(result);
                        result.setNext(n.getNext());
                        n.setNext(result);
                        this.size++;

                    }

                }
            }
        }
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public RasterRGBA get(int i) {

        if(i == 0){
            return this.getFirst();
        } else {
            doubleLinkedList n = this.head;
            while(n != null){
                if(i == 0){
                    return n.getValue();
                }
                i--;
                n = n.getNext();
            }
        }
        return null;
    }

    // Replaces the element at the specified position in this list with the specified element.
    // Returns the element that was replaced.
    // Precondition: i >= 0 && i < size().
    public RasterRGBA set(int i, RasterRGBA raster) {

        doubleLinkedList n = this.head;

        while(n != null){
            if(i == 0){
                RasterRGBA result = n.getValue();
                n.setValue(raster);
                return result;
            }
            i--;
            n = n.getNext();
        }
        return null;
    }

    // Removes the element at the specified position in this list. Shifts any subsequent
    // elements to the left (subtracts one from their indices). Returns the element that was
    // removed from the list.
    // Precondition: i >= 0 && i < size().
    public RasterRGBA remove(int i) {

        if(i == 0){
            RasterRGBA result = this.head.getValue();
            this.pollFirst();
            return result;
        } else {
            doubleLinkedList n = this.head;
            while(n != null){
                if(--i == 0){
                    if(n.getNext() == this.tail){
                        return pollLast();
                    } else {
                        RasterRGBA result = n.getNext().getValue();
                        n.setNext(n.getNext().getNext());
                        n.getNext().setPrevious(n);
                        this.size--;
                        return result;
                    }
                }
                n = n.getNext();
            }
        }
        return null;
    }

    // Returns the index of the last occurrence of 'raster' in this list (the highest index with an
    // element equal to 'raster'), or -1 if this list does not contain the element.
    // Equality of elements is determined by object identity (== operator).
    public int lastIndexOf(RasterRGBA raster) {

        doubleLinkedList n = this.head;

        int i = -1;
        int helper = 0;
        while(n != null){
            if(n.getValue().equals(raster)){
                i = helper;
            }
            n = n.getNext();
            helper++;

        }
        return i;
    }

    // Returns the number of elements in this list.
    public int size() {

        if(head == null){
            return 0;
        }
        return size;
    }

    //TODO (optional): add more operations (e.g., floodfill).
}

// TODO: define further classes, if needed (either here or in a separate file).
