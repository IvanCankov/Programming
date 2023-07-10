package Gruppe1430;
// This class represents vectors in a 3D vector space.
// Please do not modify this class.
//
public class Vector3 {

    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Returns the sum of this vector and vector 'v'.
    public Vector3 plus(Vector3 v) {
        return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    // Returns the product of this vector and 'd'.
    public Vector3 times(double d) {
        return new Vector3(this.x * d, this.y * d, this.z * d);
    }

    // Returns the sum of this vector and -1*v.
    public Vector3 minus(Vector3 v) {
        return this.plus(v.times(-1));
    }

    // Returns the Euclidean distance of this vector
    // to the specified vector 'v'.
    public double distanceTo(Vector3 v) {
        return this.minus(v).length();
    }

    // Returns the length (norm) of this vector.
    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "[x,y,z]", e.g., "[1.48E11,0.0,0.0]".
    public String toString() {
        return "[" + x + ", " + y + ", " + z + "]";
    }

}

