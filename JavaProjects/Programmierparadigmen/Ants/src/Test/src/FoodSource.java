package Test.src;

public class FoodSource {
    private final Position position; // position[0]=width, position[1]=height

    public FoodSource(Position fieldPosition) {
        this.position = fieldPosition;
    }

    public Position getPosition() {
        return this.position;
    }
}