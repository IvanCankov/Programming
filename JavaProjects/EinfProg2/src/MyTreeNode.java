import java.awt.*;

public class MyTreeNode {

    private final Point key;
    private Color value;

    private MyTreeNode left;
    private MyTreeNode right;


    public MyTreeNode(Point k, Color v, MyTreeNode l, MyTreeNode r) {
        this.key = k;
        this.value = v;
        this.left = l;
        this.right = r;
    }

    public Color add(Point k, Color v) {

        if (k.compareTo(this.key) < 0) {
            if (this.left != null) {
                this.left.add(k, v);
            } else {
                this.left = new MyTreeNode(k, v, null, null);
                return v;
            }
        } else if (k.compareTo(this.key) > 0) {
            if (this.right != null) {
                this.right.add(k, v);
            } else {
                this.right = new MyTreeNode(k, v, null, null);
                return v;
            }
        } else if (k.compareTo(this.key) == 0) {
            Color result = this.value;
            this.value = v;
            return result;
        }
        return null;
    }

    public Color search(Point k) {

        if (this.key.compareTo(k) == 0) {
            return value;
        }

        if (k.compareTo(this.key) < 0) {
            if (this.left != null) {
                return this.left.search(k);
            }
        } else if (k.compareTo(this.key) > 0) {
            if (this.right != null) {
                return this.right.search(k);
            }
        }
        return null;
    }

    public boolean searchKey(Point k) {

        if (this.key == null) {
            return false;
        }
        if (k.compareTo(this.key) < 0) {
            if (this.left != null) {
                this.left.searchKey(k);
            }
        } else if (k.compareTo(this.key) > 0) {
            if (this.right != null) {
                this.right.searchKey(k);
            }
        }
        return true;
    }

    public PointLinkedList returnList(PointLinkedList list) {
        if (left != null) {
            left.returnList(list);
        }
        list.addLast(key);
        if (right != null) {
            right.returnList(list);
        }
        return list;
    }

}
