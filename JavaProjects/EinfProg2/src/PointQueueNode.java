public class PointQueueNode {
    private PointQueueNode next;
    private Point value;

    PointQueueNode() {

    }

    PointQueueNode(Point value) {
        this.value = value;
    }

    public void setValue(Point value) {
        this.value = value;
    }

    public Point getValue() {
        return value;
    }

    public void setNext(PointQueueNode next) {
        this.next = next;
    }

    public PointQueueNode getNext() {
        return next;
    }

}
