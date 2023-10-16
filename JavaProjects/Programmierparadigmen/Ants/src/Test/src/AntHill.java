package Test.src;

public class AntHill {
    private final Position position; // position.x()=width, position.y()=height
    private int storedFood;
    public AntHill(Position fieldPosition) {
        this.position = fieldPosition;
        this.storedFood = 0;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getStoredFood() {
        return this.storedFood;
    }

    public void addFood() {
        this.storedFood++;
        System.out.println("AntHill Food: " + storedFood);
    }
}