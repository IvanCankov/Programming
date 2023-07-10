package _2019_interval.Lösung;

import java.util.*;

// 'Union' implements 'Set' and represents a union of multiple (at least two) unconnected intervals.
// Hint: It is allowed to use the java Collection-framework for the implementation (e.g., List<Interval>).
public class Union implements Set {

    private List<Interval> list = new ArrayList<>();
    public Union(Interval a, Interval b) {
        list.add(a);
        list.add(b);
    }

    // Helper method: Removes all intervals from this 'Union' which are connected to 'other'
    // (i.e., intervals where the union with 'other' is a single continuous interval).
    // The union of all the removed intervals and 'other' is returned.
    // Precondition: other != null.
    public Interval removeAllConnectedWith(Interval other) {
        ArrayList<Interval> cs = new ArrayList<>();
        //get all connected elems
        for (Interval elem: list) {
            if (elem.checkIntersecting(other)) cs.add(elem);
        }

        //remove from 'list', add to sum
        Interval sum = other;
        for (Interval c : cs){
            list.remove(c);
            sum = (Interval) sum.union(c);
        }
        return sum;
    }

    @Override
    public boolean isContinuous() {
        return list.size()==1;
    }

    @Override
    public Set union(Interval other) {
        list.add(removeAllConnectedWith(other));
        if (this.isContinuous()) return list.get(0);
        return this;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Interval> iter = list.iterator();
        return new Iterator<Integer>() {

            private Iterator<Integer> intervalIter = iter.next().iterator();
            @Override
            public boolean hasNext() {
                return iter.hasNext() || intervalIter.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("No element!");
                if (intervalIter.hasNext()) return intervalIter.next();
                intervalIter = iter.next().iterator();
                return intervalIter.next();
            }
        };
    }

    @Override
    public String toString() {
        if (list.isEmpty()) return "[]";
        String ret = "[";
        for (Interval i:list) {
            ret+=i.toString()+", ";
        }
        ret= ret.substring(0, ret.length()-2)+"]";
        return ret;
    }
}

