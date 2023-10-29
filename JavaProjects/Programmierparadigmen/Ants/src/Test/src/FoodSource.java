package Test.src;

// represents a food source on the Field
public class FoodSource extends FieldObj {
    // Addition of capacity by Ion Mihaescu
    private int capacity;

    public FoodSource(Position fieldPosition, int capacity) {

        this.position = fieldPosition;
        this.capacity = capacity;
    }

    public FoodSource(Position fieldPosition) {

        this.position = fieldPosition;
        this.capacity = 10;
    }

    public void grabFood() {
        capacity = capacity - 1;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public boolean hasFood()
    {
        return capacity > 0;
    }
}