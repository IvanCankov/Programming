import java.awt.*;

// A set with elements of 'RasterRGBA', implemented as a binary search tree. The number of elements
// is not limited. The set does not contain 'null'. The implementation uses a
// binary search tree, where the key is the number of pixels with the color (0, 0, 0, 0) in the
// raster object, and the value is the raster object itself. Note that the tree can contain
// multiple objects with the same key (for example, a subtree of a node can contain not only
// smaller, but also equal keys). However, the tree does not contain the same object
// multiple times (see the specification of the 'contains' method).
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//  if needed.
//
public class TreeSetRasterRGBA {
    MyRasterRGBATreeNode root;
    public TreeSetRasterRGBA() {}

    // Ensures that the specified element is contained in this set. If the element already
    // existed in this set, the method does not change the set and returns 'false'. Returns
    // 'true' if the set was changed as a result of the call.
    // Precondition: element != null.
    public boolean add(RasterRGBA element) {

        if (root == null) {
            root = new MyRasterRGBATreeNode(element.countPixels(new Color(0, 0, 0, 0)), element);
            return true;
        }
        return root.add(element);
    }

    // Returns true if this set contains the specified element, as determined by
    // object identity. More formally, returns 'true' if and only if this set contains
    // an object 'e' such that element == e.
    // Precondition: element != null.
    public boolean contains(RasterRGBA element) {
        return root != null && root.contains(element);
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
