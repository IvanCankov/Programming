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

    public boolean equals(Point point) {
        if(point != null) {
            return this.x == point.x && this.y == point.y;
        }
        return false;
    }
}
