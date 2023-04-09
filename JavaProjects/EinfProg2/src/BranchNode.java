import java.awt.*;

public class BranchNode {
    private BranchNode left;
    private BranchNode right;
    private Point key;
    private Color value;

    public BranchNode(Point key, Color color, BranchNode left, BranchNode right){
        this.key = key;
        this.value = color;
        this.left = left;
        this.right = right;
    }

    public void setKey(Point key) {
        this.key = key;
    }

    public Point getKey() {
        return this.key;
    }

    public BranchNode getLeft() {
        return this.left;
    }

    public void setLeft(BranchNode left) { this.left = left; }

    public BranchNode getRight() {
        return this.right;
    }

    public void setRight(BranchNode right) {
        this.right = right;
    }

    public Color getValue() {
        return this.value;
    }

    public void setValue(Color value) {
        this.value = value;
    }
}
