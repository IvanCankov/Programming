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

    public double getEuclideanDistance(Ant ant) {
        Position position = ant.getPosition();
        int x = position.x() - this.position.x();
        int y = position.y() - this.position.y();
        return Math.sqrt(Math.pow((x), 2.0) + Math.pow((y), 2.0));
    }
}