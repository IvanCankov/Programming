package Test.src;

public record Position(int x, int y) {
    public Position add(Position add) {
        return new Position(
                this.x() + add.x(),
                this.y() + add.y()
        );
    }
}
