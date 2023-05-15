import java.awt.*;

public class treeNodeRGBA {

    private int key;

    private RasterRGBA value;

    private treeNodeRGBA left;

    private treeNodeRGBA right;

    public treeNodeRGBA(int key, RasterRGBA value, treeNodeRGBA left, treeNodeRGBA right ){
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public boolean add (RasterRGBA element){

        int current = element.countPixels(new Color(0,0,0,0));

        if(this.value.equals(element)){
            return false;
        }

        if(current <= this.key ){
            if(this.left != null){
                return this.left.add(element);
            } else {
                this.left = new treeNodeRGBA(current, element,null, null);
                return true;
            }
        } else {
            if(this.right != null){
                return this.right.add(element);
            } else {
                this.right = new treeNodeRGBA(current, element,null,null);
                return true;
            }
        }
    }

    public boolean contains(RasterRGBA element){

        int current = element.countPixels(new Color(0,0,0,0));

        if(this.value.equals(element)){
            return true;
        }
        if(current <= this.key ){
            if(this.left != null){
                return this.left.contains(element);
            } else {
                return false;
            }
        } else {
            if(this.right != null){
                return this.right.contains(element);
            } else {
                return false;
            }
        }
    }
}

