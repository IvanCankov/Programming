import java.awt.*;

public class pointValueNode {
    private final Point key;
    private Color value;

    public pointValueNode(Point key, Color value) {
        this.key = key;
        this.value = value;
    }

    public Point getPoint() {
        return this.key;
    }

    public Color getColor() {
        return this.value;
    }

    public void setColor(Color c) {
        this.value = c;
    }
}
