

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;


public class BalancedStickIterator implements StarIterator {

    private Queue<Star> queue;

    public BalancedStickIterator(Mobile m) {
        this.queue = new ArrayDeque<>();
        add(m);
    }

    public void add(Mobile m) {
        if (m instanceof Star) queue.add((Star) m);
        else {
            add(((BalancedStick) m).getLeft());
            add(((BalancedStick) m).getRight());
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Star next() {
        if (hasNext()) return queue.poll();
        else throw new NoSuchElementException("no star element!");
    }
}
