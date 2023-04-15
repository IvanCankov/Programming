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

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null.
    BranchNode root;
    public Color put(Point key, Color value) {

        BranchNode newNode = new BranchNode(key, value, null, null);

        if(root == null){

            root = newNode;
        } else {

            BranchNode focusNode = root;
            BranchNode parent;

            while (true) {
                parent = focusNode;

                if (key.compareTo(focusNode.getKey()) == -1) {
                    focusNode = focusNode.getLeft();

                    if(focusNode == null) {
                        parent.setLeft(newNode);
                        return null;
                    }
                } else if (key.compareTo(focusNode.getKey()) == 1) {
                    focusNode = focusNode.getRight();

                    if(focusNode == null) {
                        parent.setRight(newNode);
                        return null;
                    }
                } else {
                    Color returned = focusNode.getValue();
                    focusNode.setValue(value);
                    return returned;
                }
            }
        }

        return null;
    }

    // Returns the value associated with the specified key, i.e. the method returns the color
    // associated with coordinates specified by key (the key must have the same coordinates as the
    // specified 'key'). Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Color get(Point key) {

        if(root== null){
            return null;
        } else {
            BranchNode focusNode = root;

            while (true) {
                if (focusNode == null) {
                    return null;
                }
                if (key.compareTo(focusNode.getKey()) == -1) {
                    focusNode = focusNode.getLeft();
                } else if (key.compareTo(focusNode.getKey()) == 1) {
                    focusNode = focusNode.getRight();
                } else {
                    return focusNode.getValue();
                }
            }
        }
    }

    // Returns 'true' if this map contains a mapping for the specified key, this means
    // for a point with the same coordinates as the specified 'key'.
    // Precondition: key != null.
    public boolean containsKey(Point key) {

        return containsHelper(this.root, key);
    }

    private boolean containsHelper(BranchNode node, Point key) {

        if (node == null) {
            return false;
        }
        if (node.getKey() == key) {
            return true;
        }

        boolean leftContains = containsHelper(node.getLeft(), key);
        boolean rightContains = containsHelper(node.getRight(), key);
        return leftContains || rightContains;
    }

    // Returns a list with all keys of this map ordered ascending according to the
    // key order relation.
    public PointLinkedList keys() {
        return traverse(root, new PointLinkedList());
    }

    private PointLinkedList traverse(BranchNode node, PointLinkedList list){
        if (node == null) {return null;}

        traverse(node.getRight(), list);
        list.addFirst(node.getKey());
        traverse(node.getLeft(), list);

        return list;
    }

    // Returns a new raster representing a region with the specified size from this
    // map. The upper left corner of the region is (0,0) and the lower right corner is (width-1, height-1).
    // All pixels outside the specified region are cropped (not included).
    // Preconditions: width > 0 && height > 0
    public SimpleRasterRGB asRasterRGB(int width, int height) {

        SimpleRasterRGB raster = new SimpleRasterRGB(width, height);
        Point maximum = new Point(width, height);
        PointLinkedList elements = keys();
        for (int i = 0; i < elements.size(); i++) {
            if (maximum.compareTo(elements.get(i)) == 1) {
                int x = elements.get(i).getX();
                int y = elements.get(i).getY();
                Color color = get(elements.get(i));
                raster.setPixelColor(x, y, color);
            }
        }

        return raster;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).

