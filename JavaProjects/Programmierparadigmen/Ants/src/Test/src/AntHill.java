package Test.src;

// represents an ant hill on the Field
public class AntHill {
    private final Position position; // position.x()=width, position.y()=height
    private int storedFood;          // how much food has been brought to the AntHill

    public AntHill(Position fieldPosition) {
        this.position = fieldPosition;
        this.storedFood = 0;
    }

    // return position of the AntHill
    public Position getPosition() {
        return this.position;
    }

    // return how much food is stored in the AntHill
    public int getStoredFood() {
        return this.storedFood;
    }

    // increment amount of stored food by 1
    public void addFood() {
        this.storedFood++;
        System.out.println("AntHill Food: " + storedFood);
    }
}