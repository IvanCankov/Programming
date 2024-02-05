import java.awt.*;

public class pointValueNode {
    private final Point point;
    private Color color;

    public pointValueNode(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
