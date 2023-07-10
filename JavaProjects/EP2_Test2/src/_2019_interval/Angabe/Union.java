package _2019_interval.Angabe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// 'Union' implements 'Set' and represents a union of multiple (at least two) unconnected intervals.
// Hint: It is allowed to use the java Collection-framework for the implementation (e.g., List<Interval>).
public class Union {


    public Union(Interval a, Interval b) {
    }

    // Helper method: Removes all intervals from this 'Union' which are connected to 'other'
    // (i.e., intervals where the union with 'other' is a single continuous interval).
    // The union of all the removed intervals and 'other' is returned.
    // Precondition: other != null.
    public Interval removeAllConnectedWith(Interval other) {
        return null;
    }

}

