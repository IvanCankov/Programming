import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(1, 1, Color.cyan);
        Point p2 = new Point(1, 2, Color.red);
        Point p3 = new Point(1, 3, Color.green);
        Point p4 = new Point(1, 4, Color.yellow);
        Point p5 = new Point(1, 5, Color.pink);
        Point p6 = new Point(1, 5, Color.white);

        LinkedList list = new LinkedList();
        list.add(new ListNode(p1));
        list.add(new ListNode(p2));
        list.add(new ListNode(p3));
        list.add(new ListNode(p4));
        list.add(new ListNode(p5));
        list.add(new ListNode(p6));

        System.out.println(list);
        System.out.println();

        for (ListNode node : list) {
            System.out.println(node);
        }

        list.remove(new Point(1, 1, Color.BLACK));
        list.remove(new Point(1, 5, Color.BLACK));
        list.remove(new Point(1, 7, Color.BLACK));

        System.out.println(list);
    }
}