public class doubleLinkedList {

    private RasterRGBA value;
    private doubleLinkedList next;

    private doubleLinkedList previous;

    public doubleLinkedList (RasterRGBA value, doubleLinkedList next, doubleLinkedList previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public void setNext(doubleLinkedList n){
        this.next = n;
    }

    public void setPrevious(doubleLinkedList p) {this.previous = p;}

    public void setValue(RasterRGBA p){
        this.value = p;
    }

    public doubleLinkedList getNext(){
        return this.next;
    }

    public doubleLinkedList getPrevious(){
        return this.previous;
    }

    public RasterRGBA getValue(){
        return this.value;
    }
}
