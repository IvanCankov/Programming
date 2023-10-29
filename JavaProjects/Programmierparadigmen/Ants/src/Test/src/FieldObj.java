package Test.src;

/**
 * Shared fields between Ant, AntHill and FoodSource
 * @author Mathias Engel
 */
public class FieldObj {
    protected Position position; // position.x() coordinate in width, position.y() coordinate in height

    public Position getPosition() {
        return this.position;
    }
}
