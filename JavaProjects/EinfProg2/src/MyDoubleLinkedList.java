public class MyDoubleLinkedList {

    private RasterRGBA value;
    private MyDoubleLinkedList next;

    private MyDoubleLinkedList previous;

    public MyDoubleLinkedList(RasterRGBA value) {
        this.value = value;
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
