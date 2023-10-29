package Test.src;

public record Position(int x, int y) {
    public Position add(Position add) {
        return new Position(
                this.x() + add.x(),
                this.y() + add.y()
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!obj.getClass().equals(Position.class)) return false;
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }
}
