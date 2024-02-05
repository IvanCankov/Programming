// A class for representing points with integer coordinates in 2D.

public record Point(int x, int y) implements Comparable<Point> {
    // Initializes this point with its coordinates.

    // Compares this point with a specified point. Defines an order relation ("less-than"
    // relation) on objects of 'Point'. Returns 0 if and only if the two coordinates of 'this'
    // and 'p' are equal. Returns -1 if 'this' is less than 'p' or 1 otherwise.
    // Precondition: p != null
    public int compareTo(Point p) {

        if (this.x < p.x()) {
            return -1;
        }

        if (this.x > p.x()) {
            return 1;
        }

        return Integer.compare(this.y, p.y());

    }

    @Override
    // Returns a string representation of 'this'.
    public String toString() {

        return "[" + x() + ", " + y() + "]";
    }

}
