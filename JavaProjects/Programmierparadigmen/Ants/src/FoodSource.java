class FoodSource {
    private final int[] position; // position[0]=width, position[1]=height

    public FoodSource(int[] fieldPosition) {
        this.position = fieldPosition;
    }

    public int[] getPosition() {
        return this.position;
    }
}