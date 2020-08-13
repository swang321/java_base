package collection.tree;

/**
 * @author swang
 */
public class Node {

    public Node left;
    public Node right;
    public Object data;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, int data, Node right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", data=" + data +
                ", right=" + right +
                '}';
    }
}
