public class MyDoubleLinkedList {

    private RasterRGBA value;
    private MyDoubleLinkedList next;

    private MyDoubleLinkedList previous;

    public MyDoubleLinkedList(RasterRGBA value, MyDoubleLinkedList next, MyDoubleLinkedList previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public void setNext(MyDoubleLinkedList n) {
        this.next = n;
    }

    public void setPrevious(MyDoubleLinkedList p) {
        this.previous = p;
    }

    public void setValue(RasterRGBA p) {
        this.value = p;
    }

    public MyDoubleLinkedList getNext() {
        return this.next;
    }

    public MyDoubleLinkedList getPrevious() {
        return this.previous;
    }

    public RasterRGBA getValue() {
        return this.value;
    }
}
