import java.awt.*;

// A map that associates a position with a color. The number of key-value pairs is not limited.
// The map does not contain any keys or values being 'null'.
//
public class SimplePointColorMap {
    private int rear;
    private Point[] keys;
    private Color[] values;

    // Initializes this map with an initial capacity (length of internal array).
    // Precondition: initialCapacity > 0.
    public SimplePointColorMap(int initialCapacity) {
        this.keys = new Point[initialCapacity];
        this.values = new Color[initialCapacity];
        this.rear = 0;
    }

    private int find(Point point, Point[] keys) {
        int i = 0;
        while (i < rear) {
            if (keys[i] != null && keys[i].equals(point)) {
                break;
            }
            i++;
        }
        return i;
    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null && value != null.
    public Color put(Point key, Color value) {
        int i = find(key, this.keys);
        if (i == rear && ++rear == keys.length) {
            enlargeArrays();
        }
        this.keys[i] = key;
        Color old = values[i];
        this.values[i] = value;
        return old;
    }

    private void enlargeArrays() {
        Point[] keys2 = new Point[this.keys.length * 2];
        Color[] values2 = new Color[this.values.length * 2];
        for (int i = 0; i < this.keys.length; i++) {
            keys2[i] = this.keys[i];
            values2[i] = this.values[i];
        }
        this.keys = keys2;
        this.values = values2;
    }

    public Color get(Point key) {
        return values[find(key, keys)];
    }

    public Color remove(Point key) {
        int index = find(key, keys);

        // Key not found
        if (index == rear) {
            return null;
        }
        //ret colour oh yeaa
        Color oldColour = values[index];

        for (int i = index; i < rear - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        rear--;
        keys[rear] = null;
        values[rear] = null;

        return oldColour;
    }

    // Returns a queue with all keys of this map (ordering is not specified).
    public SimplePointQueue keys() {
        SimplePointQueue pointQueue = new SimplePointQueue(this.keys.length);
        for(int i = 0; i <= rear; i++) {
            pointQueue.add(this.keys[i]);
        }
        return pointQueue;
    }
public int getLength(SimplePointColorMap map){
        return  keys.length;
}

    public void putMap(SimplePointColorMap map) {
        map.enlargeArrays();
        SimplePointColorMap map2 = new SimplePointColorMap(keys().size() + keys.length);
        int i=0;
        for (; i < keys.length; i++) {
            if (keys[i] != null) {
                //for (int j = 0; j < keys; j++) {  }doppelte for-Schleife um zu sehen ob keys[] bereits die keys von map enthält, wenn ja wird dieser Eintrag übersprungen und nicht in die neue map2 gegeben
                    // wenn es schon einen key gibt in keys[], dann set.color(Point[i]) auf maximum;

                map.put(keys[i],values[i]);
            }


        }
        for (int j = 0; j < map.getLength(map); j++) {
            map.put(keys[i+j],values[i+j]);
        }

    }


}
