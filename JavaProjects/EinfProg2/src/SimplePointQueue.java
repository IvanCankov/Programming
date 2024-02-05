public class SimplePointQueue {

    private PointQueueNode head;
    private PointQueueNode tail;
    private int size;

    public SimplePointQueue(int capacity) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Point p) {
        PointQueueNode newNode = new PointQueueNode(p);

        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;

        size++;
    }

    public Point poll() {
        if (head == null) {
            return null;
        }

        Point p = head.getValue();
        head = head.getNext();
        size--;

        if (head == null) {
            tail = null;
        }

        return p;
    }

    public Point peek() {
        return (head != null) ? head.getValue() : null;
    }

    public int size() {
        return size;
    }

    public Point delete(int i) {
        if (i < 0 || i >= size || head == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }

        Point result;
        if (i == 0) {
            result = head.getValue();
            head = head.getNext();
            size--;

            if (head == null) {
                tail = null;
            }
        } else {
            PointQueueNode current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.getNext();
            }

            result = current.getNext().getValue();
            current.setNext(current.getNext().getNext());

            if (current.getNext() == null) {
                tail = current;
            }

            size--;
        }

        return result;
    }

    public boolean removeAll(Point p) {
        boolean flag = false;

        while (head != null && p.compareTo(head.getValue()) == 0) {
            head = head.getNext();
            size--;
            flag = true;
        }

        PointQueueNode current = head;
        PointQueueNode previous = null;

        while (current != null) {
            if (p.compareTo(current.getValue()) == 0) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() == null) {
                    tail = previous;
                }

                size--;
                flag = true;
            } else {
                previous = current;
            }

            current = current.getNext();
        }

        return flag;
    }
}
