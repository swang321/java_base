package collection.tree;

/**
 * @Date: 2019/1/17 9:37
 * @Description:
 * @Author admin
 */
public class TreeMain {

    public static void main(String[] args) {

        Node root = createNode();
        MyBinaryTree myBinaryTree = new MyBinaryTree(root);

        System.out.println(myBinaryTree.isEmpty());
        System.out.println(myBinaryTree.getHeight());
        System.out.println(myBinaryTree.size());
        System.out.println(myBinaryTree.findKey(7));

        System.out.println("---------------------------------------");
        System.out.print("递归前序遍历: ");
        myBinaryTree.preOrderTraverse();
        System.out.println();

        System.out.print("递归中序遍历: ");
        myBinaryTree.inOrderTraverse();
        System.out.println();

        System.out.print("递归后序遍历: ");
        myBinaryTree.postOrderTraverse();
        System.out.println();
    }

    /**
     * 建立一棵树
     */
    private static Node createNode() {
        Node node5 = new Node(null, 5, null);
        Node node4 = new Node(null, 4, node5);
        Node node7 = new Node(null, 7, null);
        Node node6 = new Node(null, 6, node7);
        Node node3 = new Node(null, 3, null);
        Node node2 = new Node(node3, 2, node6);
        return new Node(node4, 1, node2);
    }

}
