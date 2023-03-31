public class SimplePointQueue {
    Point[] queue;

    public SimplePointQueue(int initialCapacity) {

        this.queue = new Point[initialCapacity];
    }

    public void add(Point p) {

        if(size() >= queue.length) {
            enlargeArray();
        }
        queue[size()] = p;
    }

    private void enlargeArray() {

        Point[] queue2 = new Point[this.queue.length * 2];
        for (int i = 0; i < this.queue.length; i++) {
            queue2[i] = this.queue[i];
        }
        this.queue = queue2;
    }

    // Retrieves and removes the head of this queue, or returns 'null'
    // if this queue is empty.
    public Point poll() {

        if (queue.length == 0){
            return null;
        }

        Point p = queue[0];
        Point[] queue2 = new Point[size()];
        System.arraycopy(queue, 1, queue2, 0, size() - 1);
        queue = queue2; // just to delete that last element wow
        return p;
    }

    public Point peek() {

        if (size() == 0){
            return null;
        }
        return queue[0]; //literal peak human evolution
    }

    // Returns the number of entries in this queue.
    public int size() {
        int size = 0;

        for (Point point : queue) { //eqv. of for point in point .py aaaaaaaaaaaaaaaaaaaa
            if (point != null) {
                size++;
            }
        }
        return size;
    }
}
