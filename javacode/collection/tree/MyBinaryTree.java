package collection.tree;

/**
 * @Date: 2019/1/17 9:34
 * @Description:
 * @Author admin
 */
public class MyBinaryTree implements BinaryTree {
    /**
     * 根节点
     */
    private Node root;

    public MyBinaryTree() {
    }

    public MyBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            int nl = this.size(root.getLeft());
            int nr = this.size(root.getRight());
            return nl + nr + 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return root.data == null && root.left == null && root.right == null;
    }

    @Override
    public int getHeight() {
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int nl = this.getHeight(root.getLeft());
            int nr = this.getHeight(root.getRight());
            return nl > nr ? nl + 1 : nr + 1;
        }
    }

    @Override
    public Node findKey(int value) {
        return this.findKey(value, root);
    }

    private Node findKey(Object value, Node root) {
        if (root == null) {
            return null;
        } else if (root.data == value) {
            return root;
        } else {
            Node left = findKey(value, root.getLeft());
            Node right = findKey(value, root.getRight());
            if (left != null && left.data == value) {
                return left;
            }
            if (right != null && right.data == value) {
                return right;
            }
        }
        return null;
    }

    @Override
    public void preOrderTraverse() {
        this.preOrderTraverse(root);
    }

    private void preOrderTraverse(Node root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            // 对左树递归遍历
            preOrderTraverse(root.getLeft());
            // 对右树递归遍历
            preOrderTraverse(root.getRight());
        }
    }

    @Override
    public void inOrderTraverse() {
        this.inOrderTraverse(root);
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {
            // 对左树递归遍历
            inOrderTraverse(root.getLeft());
            System.out.print(root.getData() + " ");
            // 对右树递归遍历
            inOrderTraverse(root.getRight());
        }
    }

    @Override
    public void postOrderTraverse() {
        this.postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root) {
        if (root != null) {
            // 对左树递归遍历
            postOrderTraverse(root.getLeft());
            // 对右树递归遍历
            postOrderTraverse(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void leveOrderByStack() {

    }
}
