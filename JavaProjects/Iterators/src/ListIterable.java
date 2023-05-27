import java.util.Iterator;

public interface ListIterable extends Iterable<ListNode> {

    @Override
    ListIterator iterator();
}
