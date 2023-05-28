// Represents an empty song list.
//
// 'add' returns a 'NonEmptyList'.
//
public class EmptyList implements SongList {

    // only one instance is needed.
    public static final EmptyList EMPTY = new EmptyList();

    //TODO: define missing parts of the class.

    private EmptyList() {} // may be changed to public, if needed (depending on your solution).


    @Override
    public Song first() {
        return null;
    }

    @Override
    public SongList afterFirst() {
        return null;
    }

    @Override
    public SongList add(Song song) {
        return new NonEmptyList(song);
    }

    @Override
    public SongList remove(Song song) {
        return null;
    }

    @Override
    public SongIterator iterator() {
        return null;
    }
}
