import java.util.NoSuchElementException;
import java.util.Stack;

public class BalancedStcikIterator  implements StarIterator{


    private Stack<Mobile> stack;
    private Mobile nextLeaf;

    public BalancedStcikIterator(Mobile rootNode) {
        stack = new Stack<>();
        stack.push(rootNode);
        findNextLeaf();
    }

    public boolean hasNext() {
        return nextLeaf != null;
    }

    public Star next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no star element!");
        }
        Mobile leafNode = nextLeaf;
        findNextLeaf();
        return (Star) leafNode;
    }

    private void findNextLeaf() {
        nextLeaf = null;
        while (!stack.isEmpty()) {
            Mobile node = stack.pop();
            if (node instanceof BalancedStick) {
                BalancedStick balancedStick = (BalancedStick) node;

                if (balancedStick.getRight() != null) {
                    stack.push(balancedStick.getRight());
                }
                if (balancedStick.getLeft() != null) {
                    stack.push(balancedStick.getLeft());
                }

            } else if (node instanceof Star) {
                nextLeaf = node;
                return;
            }
        }
    }
}
