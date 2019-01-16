package collection.tree;

/**
 * @author swang
 */
public class Node {

    private Node left;
    private Node right;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
