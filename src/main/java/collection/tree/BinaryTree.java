package collection.tree;

/**
 * @author admin
 */
public interface BinaryTree {

    /**
     * 树节点数量
     */
    int size();

    /**
     * 返回树得高度
     */
    boolean isEmpty();

    /**
     * 树的高度  此节点得高度
     */
    int getHeight();

    /**
     * 查询值指定的节点
     */
    Node findKey(int value);

    /**
     * 前序遍历
     */
    void preOrderTraverse();

    /**
     * 中序遍历
     */
    void inOrderTraverse();

    /**
     * 后序遍历
     */
    void postOrderTraverse();

    /**
     * 前序遍历    (非递归 栈来实现)
     */
    void inOrderByStack();

    /**
     * 中序遍历 非递归
     */
    void preOrderByStack();

    /**
     * 后序遍历 非递归
     */
    void postOrderByStack();

    /**
     * 按照层次遍历二叉树  (队列实现)
     */
    void leveOrderByStack();

}
