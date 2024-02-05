import java.awt.*;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Collection;

// A map that associates a position with a color. The number of key-value pairs is not limited.
// The map does not contain any keys or values being 'null'.
//
public class SimplePointColorMap {
    private int size;
    private Point[] keysArray;
    private Color[] valuesArray;

    public SimplePointColorMap(int initialCapacity) {
        this.size = 0;
        this.keysArray = new Point[initialCapacity];
        this.valuesArray = new Color[initialCapacity];
    }

    public Color put(Point key, Color value) {
        int index = find(key, keysArray);
        if (index == size) {
            ensureCapacity();
        }
        Color old = valuesArray[index];
        keysArray[index] = key;
        valuesArray[index] = value;
        if (index == size) {
            size++;
        }
        return old;
    }

    public Color get(Point key) {
        return valuesArray[find(key, keysArray)];
    }

    public Color remove(Point key) {
        int index = find(key, keysArray);
        Color old = valuesArray[index];
        if (index < size) {
            keysArray[index] = keysArray[--size];
            keysArray[size] = null;
            valuesArray[index] = valuesArray[size];
            valuesArray[size] = null;
        }
        return old;
    }

    public SimplePointQueue keys() {
        SimplePointQueue result = new SimplePointQueue(size);
        for (int i = 0; i < size; i++) {
            result.add(keysArray[i]);
        }
        return result;
    }

    public boolean contains(Point p) {
        for (int i = 0; i < size; i++) {
            if (p == null ? p == keysArray[i] : p.equals(keysArray[i])) {
                return true;
            }
        }
        return false;
    }

    private int find(Point p, Point[] array) {
        for (int i = 0; i < size; i++) {
            if (p == null ? p == array[i] : p.equals(array[i])) {
                return i;
            }
        }
        return size;
    }

    private void ensureCapacity() {
        if (size == keysArray.length) {
            int newCapacity = keysArray.length << 1;
            keysArray = Arrays.copyOf(keysArray, newCapacity);
            valuesArray = Arrays.copyOf(valuesArray, newCapacity);
        }
    }