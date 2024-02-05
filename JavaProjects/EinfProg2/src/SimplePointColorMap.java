import java.awt.*;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Collection;

// A map that associates a position with a color. The number of key-value pairs is not limited.
// The map does not contain any keys or values being 'null'.
//
public class SimplePointColorMap {

    private int top;

    private Point[] keysArray;
    private Color[] valuesArray;


    // Initializes this map with an initial capacity (length of internal array).
    // Precondition: initialCapacity > 0.
    public SimplePointColorMap(int initialCapacity) {
        this.keysArray = new Point[initialCapacity];
        this.valuesArray = new Color[initialCapacity];
    }

    private int find(Point p, Point[] queue) {


        int i = 0;
        while (i < top &&
                !(p == null ? p == queue[i] : p.compareTo(queue[i]) == 0))
            i++;
        return i;

    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null && value != null.
    public Color put(Point key, Color value) {
        int i = find(key, this.keysArray);
        if (i == top && ++top == keysArray.length) {
            Point[] nks = new Point[top << 1];
            Color[] nvs = new Color[top << 1];
            for (int j = 0; j < i; j++) {
                nks[j] = this.keysArray[j];
                nvs[j] = this.valuesArray[j];
            }
            this.keysArray = nks;
            this.valuesArray = nvs;
        }
        keysArray[i] = key;
        Color old = valuesArray[i];
        valuesArray[i] = value;
        return old;
    }

    // Returns the value associated with the specified key, i.e. the method returns the color
    // associated with the specified point.
    // More formally, if this map contains a mapping from a key k to a value v such that
    // key.compareTo(k) == 0, then this method returns v.
    // (There can be at most one such mapping.)
    // Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Color get(Point key) {
        return valuesArray[find(key, keysArray)];

    }

    // Removes the mapping for a key from this map if it is present. More formally, if this map
    // contains a mapping from key k to value v such that key.compareTo(k) == 0,
    // that mapping is removed. (The map can contain at most one such mapping.)
    // Returns the value to which this map previously associated the key, or 'null' if the map
    // contained no mapping for the key.
    // Precondition: key != null.
    public Color remove(Point key) {

        int i = find(key, keysArray);
        Color old = valuesArray[i];
        if (i < top) {
            keysArray[i] = keysArray[--top];
            keysArray[top] = null;
            valuesArray[i] = valuesArray[top];
            valuesArray[top] = null;
        }
        return old;
    }

    // Returns a queue with all keys of this map (ordering is not specified).
    public SimplePointQueue keys() {

        SimplePointQueue result = new SimplePointQueue(1);
        for (int i = 0; i < keysArray.length; i++) {
            result.add(keysArray[i]);
        }

        return result;
    }

    public boolean contains(Point p) {
        for (Point point : keysArray) {
            if (p == null ? p == point : p.equals(point)) {
                return true;
            }
        }
        return false;
    }
}