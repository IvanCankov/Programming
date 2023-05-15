import java.awt.*;
import java.util.Objects;

// A map that associates a position (objects of type 'Point') with a color (objects of type 'Color').
// The number of key-value pairs is not limited.
// The map is implemented as hash map. The map does not contain any keys or values being 'null'.
//
public class HashPointColorMap {

    private pointValueNode[] hashPointArray = new pointValueNode[10];

    private void resize() {
        int newCapacity = hashPointArray.length * 2; // Double the current capacity or choose another resizing strategy
        pointValueNode[] newArray = new pointValueNode[newCapacity];

        // Rehash existing key-value pairs into the new array
        for (int i = 0; i < hashPointArray.length; i++) {
            pointValueNode entry = hashPointArray[i];
            if (entry != null) {
                int newIndex = entry.getPoint().hashCode() % newCapacity;
                while (newArray[newIndex] != null) {
                    newIndex = (newIndex + 1) % newCapacity; // Linear probing
                }
                newArray[newIndex] = entry;
            }
        }
        // Update the underlying array reference
        this.hashPointArray = newArray;
    }

    public Color put(Point key, Color value) {
        int hash = key.hashCode() % hashPointArray.length;
        int index = hash;
        while (true) {
            if (hashPointArray[index] == null) {
                hashPointArray[index] = new pointValueNode(key, value);
                return null;
            } else if (hashPointArray[index].getPoint().equals(key)) {
                Color temp = hashPointArray[index].getColor();
                hashPointArray[index].setColor(value);
                return temp;
            }
            index = (index + 1) % hashPointArray.length; // Linear probing
            if (index == hash) {
                resize();
                put(key, value);
                return null;
            }
        }
    }

    public Color get(Point key) {
        int hash = key.hashCode() % hashPointArray.length;
        int index = hash;
        while (true) {
            if (hashPointArray[index] == null) {
                return null; // Key not found
            } else if (hashPointArray[index].getPoint().equals(key)) {
                return hashPointArray[index].getColor(); // Matching key found, return the associated value
            }
            index = (index + 1) % hashPointArray.length; // Linear probing
            if (index == hash) {
                return null; // Reached the original index, key not found
            }
        }
    }

    public Color remove(Point key) {
        int hash = key.hashCode() % hashPointArray.length;
        int index = hash;
        while (true) {
            if (hashPointArray[index] == null) {
                return null; // Key not found, no action needed
            } else if (hashPointArray[index].getPoint().equals(key)) {
                Color temp = hashPointArray[index].getColor();
                hashPointArray[index] = null; // Matching key found, remove the entry
                return temp;
            }
            index = (index + 1) % hashPointArray.length; // Linear probing
            if (index == hash) {
                return null; // Reached the original index, key not found, no action needed
            }
        }
    }

    // Returns a queue with all keys of this map (ordering is not specified).
    public SimplePointQueue keys() {
        SimplePointQueue queue = new SimplePointQueue(20);

        for (int i = 0; i < hashPointArray.length; i++) {
            if (hashPointArray[i] != null) {
                queue.add(hashPointArray[i].getPoint());
            }
        }
        return queue;
    }

    // Returns 'true' if the specified key is contained in this map.
    // Returns 'false' otherwise.
    public boolean containsKey(Point key) {

        int hash = key.hashCode() % hashPointArray.length;
        int index = hash;
        while (true) {
            if (hashPointArray[index] == null) {
                return false; // Key not found
            } else if (hashPointArray[index].getPoint().equals(key)) {
                return true; // Matching key found, return the associated value
            }
            index = (index + 1) % hashPointArray.length; // Linear probing
            if (index == hash) {
                return false; // Reached the original index, key not found
            }
        }
    }

    // Returns 'true' if the specified value is contained at least once in this map.
    // Returns 'false' otherwise.
    public boolean containsValue(Color value) {
        for (int i = 0; i < hashPointArray.length; i++) {
            pointValueNode entry = hashPointArray[i];
            if (entry != null && entry.getColor().equals(value)) {
                return true; // Matching value found
            }
        }
        return false; // Value not found
    }

    // Returns a string representation of this map with key-value pairs in parentheses, separated
    // by commas (order is not specified).
    // Example: {([9, 2], java.awt.Color[r=255,g=255,b=0]), ([7, 1], java.awt.Color[r=255,g=0,b=0])}
    public String toString() {
        StringBuilder outString = new StringBuilder("{");
        SimplePointQueue keys = keys();
        for (int i = 0; i < keys.size(); i++) {
            Point nextKey = keys.poll();
            outString.append("(");
            outString.append(nextKey.toString()).append(", ");
            outString.append(get(nextKey).toString());
            outString.append(")");
            if (i != keys.size() - 1)
            {
                outString.append(", ");
            }
        }
        outString.append("}");
        return outString.toString();
    }

    // Returns 'true' if 'this' and 'o' are equal, meaning 'o' is of class 'HashPointColorMap'
    // and 'this' and 'o' contain the same key-value pairs, i.e. the number of key-value pairs is
    // the same in both maps and every key-value pair in 'this' equals one key-value pair in 'o'.
    // Two key-value pairs are equal if the two keys are equal and the two values are equal.
    // Otherwise, 'false' is returned.
    public boolean equals(Object o) {
        if (o == null)
        {
            return false;
        }
        if (o.getClass().equals(HashPointColorMap.class))
        {
            HashPointColorMap oMap = (HashPointColorMap) o;
            SimplePointQueue thisKeys = keys();
            SimplePointQueue oKeys = oMap.keys();
            if (thisKeys.size() != oKeys.size())
            {
                return false;
            }
            for (int i = 0; i < thisKeys.size(); i++) {
                Point nextKey = thisKeys.poll();
                if (!oMap.containsKey(nextKey)) return false;
                if (!oMap.get(nextKey).equals(get(nextKey))) return false;
            }
        }
        return true;
    }



    // Returns the hash code of 'this'.
    public int hashCode() {
        int sum = 0;
        for (pointValueNode entry : hashPointArray) {
            if (entry != null)
            {
                sum += entry.hashCode();
            }
        }
        return Objects.hash(hashPointArray.length, sum);
    }
}

