public class AntHill {
    private final int[] position; // position[0]=width, position[1]=height
    private int storedFood;
    public AntHill(int[] fieldPosition) {
        this.position = fieldPosition;
        this.storedFood = 0;
    }

    public int[] getPosition() {
        return this.position;
    }

    public int getStoredFood() {
        return this.storedFood;
    }

    public void addFood() {
        this.storedFood++;
    }
}