import java.awt.*;

// A map that associates a position (objects of type 'Point') with a color (objects of type 'Color'). The number of
// key-value pairs is not limited.
// The map is implemented as a binary tree. The keys are ordered based on the 'compareTo' method of 'Point'.
// The map does not contain any keys being 'null'.
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//  if needed.
//
public class TreePointColorMap {

    MyTreeNode root;

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null.
    public Color put(Point key, Color value) {

        if (root == null) {
            root = new MyTreeNode(key, value, null, null);
            return value;
        }
        return root.add(key, value);
    }

    // Returns the value associated with the specified key, i.e. the method returns the color
    // associated with coordinates specified by key (the key must have the same coordinates as the
    // specified 'key'). Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Color get(Point key) {

        if (root == null) {
            return null;
        }
        return root.search(key);
    }

    // Returns 'true' if this map contains a mapping for the specified key, this means
    // for a point with the same coordinates as the specified 'key'.
    // Precondition: key != null.
    public boolean containsKey(Point key) {

        if (root == null) {
            return false;
        }
        return root.searchKey(key);
    }

    // Returns a list with all keys of this map ordered ascending according to the
    // key order relation.
    public PointLinkedList keys() {

        if (root == null) {
            return new PointLinkedList();
        }
        return root.returnList(new PointLinkedList());

    }

    // Returns a new raster representing a region with the specified size from this
    // map. The upper left corner of the region is (0,0) and the lower right corner is (width-1, height-1).
    // All pixels outside the specified region are cropped (not included).
    // Preconditions: width > 0 && height > 0
    public SimpleRasterRGB asRasterRGB(int width, int height) {

        //TODO: implement method.
        SimpleRasterRGB result = new SimpleRasterRGB(width, height);
        PointLinkedList coordinates = root.returnList(new PointLinkedList());


        for (MyListNode n = coordinates.head; n != null; n = n.getNext()) {
            if (n.getValue().x() < width && n.getValue().y() < height) {
                result.setPixelColor(n.getValue().x(), n.getValue().y(), root.search(n.getValue()));
            }


        }

        return result;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).

