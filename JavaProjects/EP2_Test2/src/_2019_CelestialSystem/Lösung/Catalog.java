package _2019_CelestialSystem.Lösung;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// A hash map with keys of type 'CelestialSystem' and values of type 'String' corresponding to the
// name of the system.
//
public class Catalog {

    // TODO: declare private variables.
    //  You can use predefined Java classes (e.g. java.util.HashMap).
    private Map<CelestialSystem, String> map = new HashMap<>();

    // Associates the specified system 'key' with the specified name 'value' in this map.
    // If the map previously contained a mapping for the key, the old value is replaced.
    // Returns the previous value associated with key, or 'null' if there was no mapping for key.
    // Precondition: key != null, value != null.
    public String put(CelestialSystem key, String value) {
        // TODO: implement method.
        return map.put(key, value);

    }

    // Returns 'true' if this map contains a mapping for the specified key.
    public boolean containsKey(CelestialSystem key) {
        // TODO: implement method.
        Iterator<CelestialSystem> iter = map.keySet().iterator();
        while (iter.hasNext()){
            CelestialSystem next = iter.next();
            if(next.equals(key)) return true;
        }
        return false;

    }

    // Returns the value to which the specified key is mapped,
    // or 'null' if this map contains no mapping for the key.
    public String get(CelestialSystem key) {
        // TODO: implement method.
        Iterator<CelestialSystem> iter = map.keySet().iterator();
        while (iter.hasNext()){
            CelestialSystem next = iter.next();
            if(next.equals(key)) {
                return map.get(next);
            }
        }
        return null;
    }

    // In this class it is NOT necessary to override methods from 'Object' .
}
