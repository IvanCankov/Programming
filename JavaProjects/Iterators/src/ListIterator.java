import java.util.Iterator;

public interface ListIterator extends Iterator<ListNode> {

    @Override
    ListNode next();


    @Override
    boolean hasNext();
}

