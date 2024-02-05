public class MyLayeredRasterRGBAIterator implements RasterizedRGBIterator {


    private MyDoubleLinkedList mylist;

    public MyLayeredRasterRGBAIterator(MyDoubleLinkedList tail) {
        this.mylist = tail;
    }


    // ..man this here is weird like we iterate trozdem forward and then check if it is null
    // why we do this idk but i gotta get used to it
    // it is fun but yea
    @Override
    public RasterizedRGB next() {

        if (!hasNext()) return null;
        RasterRGBA result = this.mylist.getValue();
        this.mylist = mylist.getPrevious();
        return result;
    }

    @Override
    public boolean hasNext() {
        return mylist != null;
    }
}
