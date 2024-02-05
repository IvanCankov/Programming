// Represents a succession of two operations. Each of which can be itself of type
// 'SafeOperationSequence' such that this class represents a recursive (tree-like)
// structure. The foundation (leafs of the tree) is represented by objects of
// 'SafeSingleOperation'.
public class SafeOperationSequence implements SafeOperation, SafeOperationIterable {

    //TODO: define missing parts of this class.

    public SafeOperationSequence(SafeOperation first, SafeOperation second) {

        //TODO: implement constructor.
    }

    @Override
    public RasterizedRGB execute(RasterizedRGB raster) throws OperationException {

        //TODO: implement method.
        return null;
    }

    public SafeOperation getFirst() {

        //TODO: implement method.
        return null;
    }

    public SafeOperation getSecond() {

        //TODO: implement method.
        return null;
    }

    @Override
    public SafeOperationIterator iterator() {

        //TODO: implement method.
        return null;
    }

    @Override
    public String toString() {

        //TODO: implement method.
        return "";
    }
}

//TODO: additional classes for the implementation of the iterator.
