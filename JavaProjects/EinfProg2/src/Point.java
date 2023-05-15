// A class for representing points with integer coordinates in 2D.
public class Point {
    private final int x, y;

    // Initializes this point with its coordinates.
    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    // Returns the x-coordinate of this point.
    public int getX() {

        return x;
    }

    // Returns the y-coordinate of this point.
    public int getY() {

        return y;
    }

    public int compareTo(Point p) {
        if (this.equals(p)) {
            return 0;
        }
        return (this.x > p.getX() || (this.x == p.getX() && this.y > p.getY())) ? 1 : -1;
    }

    @Override
    // Returns 'true' if 'o' is of class 'Point' and has coordinates equal to those of 'this'.
    // (This means that for two objects p1 and p2 of 'Point', p1.equals(p2) == true if and only if
    // p1.compareTo(p2) == 0.)
    // Return 'false' otherwise.
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point otherPoint = (Point) o;
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    @Override
    // Returns the hash code of 'this'.
    public int hashCode() {

        final int prime = 31;
        int hashCode = 17;

        hashCode = prime * hashCode + x;
        hashCode = prime * hashCode + y;

        return hashCode;
    }

    @Override
    // Returns a string representation of 'this'.
    public String toString() {

        return "[" + getX() + ", " + getY() + "]";
    }

}
