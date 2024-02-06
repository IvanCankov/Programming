import java.awt.*;

public class MyRasterRGBATreeNode {

    private final int key;

    private final RasterRGBA value;

    private MyRasterRGBATreeNode left;

    private MyRasterRGBATreeNode right;

    public MyRasterRGBATreeNode(int key, RasterRGBA value) {
        this.key = key;
        this.value = value;
    }


    public boolean add(RasterRGBA element) {
        int current = element.countPixels(new Color(0, 0, 0, 0));

        if (this.value.equals(element)) {
            return false;
        }

        MyRasterRGBATreeNode newNode = new MyRasterRGBATreeNode(current, element);

        if (current <= this.key) {
            if (this.left == null) {
                this.left = newNode;
                return true;
            } else {
                return this.left.add(element);
            }
        } else {
            if (this.right == null) {
                this.right = newNode;
                return true;
            } else {
                return this.right.add(element);
            }
        }
    }


    public boolean contains(RasterRGBA element) {
        int current = element.countPixels(new Color(0, 0, 0, 0));

        if (this.value.equals(element)) {
            return true;

        }

        if (current <= this.key) {
            if (this.left != null) {
                return this.left.contains(element);
            } else {
                return false;
            }
        } else {
            if (this.right != null) {
                return this.right.contains(element);
            } else {
                return false;
            }
        }
    }
}
