public class Node {
    private Point value;
    private Node next;

    public Node(Point point, Node next) {
        this.value = point;
        this.next = next;
    }

    public Point value() {
        return this.value;
    }

    public Node next(){
        return this.next;
    }

    //sets the pointer to the next node
    public void setNext(Node n){
        this.next = n;
    }

    public void setValue(Point point){
        this.value = point;
    }
}
