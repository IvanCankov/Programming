package Gruppe1130;
// This class represents vectors in a 2D vector space with integer coordinates.
// Please do not modify this class.
//
public class Vector2 {

    private int x;
    private int y;

    // Initializes this vector with x and y.
    public Vector2(int x, int y) {

        this.x = x;
        this.y = y;
    }

    // Compares two vectors. The result is -1 if the x-coordinate of this vector is less than the
    // x-coordinate of 'v'. In case of equal x-coordinates the result is -1 if the y-coordinate
    // of this body is less than the y-coordinate of 'b'. The result is zero if this vector
    // equals 'v' in both coordinates. In all other cases the result is 1.
    public int compareTo(Vector2 v) {
        int result = this.x < v.x
                        ? -1
                        : this.x == v.x ? 0 : 1;
        return result == 0
                        ? this.y < v.y
                            ? -1
                            : this.y == v.y ? 0 : 1
                        : result;
    }

    // The equals method.
    // (Defined for completion - not needed for solution).
    public boolean equals(Object o) {
        if (o == null || o.getClass() != Vector2.class) {
            return false;
        }

        Vector2 v = (Vector2) o;
        return this.x == v.x && this.y == v.y;

    }

    // The hashCode method.
    // (Defined for completion - not needed for solution).
    public int hashCode() {
        int hashCode = 23;
        hashCode = (hashCode * 37) + x;
        hashCode = (hashCode * 37) + y;
        return hashCode;

    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "(x,y)", e.g., "(-7,2)".
    public String toString() {

        return "(" + x + "," + y+ ")";
    }

}

