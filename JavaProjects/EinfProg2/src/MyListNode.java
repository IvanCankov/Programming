public class MyListNode {
    private Point value;
    private MyListNode next;

    public MyListNode(Point v, MyListNode n) {
        this.value = v;
        this.next = n;
    }

    public void setNext(MyListNode n) {
        this.next = n;
    }


    public void setValue(Point p) {
        this.value = p;
    }

    public MyListNode getNext() {
        return this.next;
    }


    public Point getValue() {
        return this.value;
    }

}
