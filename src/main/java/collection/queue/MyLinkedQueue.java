package collection.queue;

/**
 * @Date: 2019/1/9 14:28
 * @Description:
 * @Author admin
 */
public class MyLinkedQueue implements IMyQueue {

    /**
     * 队列当前长度
     */
    private int size;
    /**
     * 队列头，允许删除
     */
    private Node front;
    /**
     * 队列尾，允许插入
     */
    private Node rear;

    public MyLinkedQueue() {
    }

    @Override
    public boolean add(Object obj) {
        Node node = new Node(obj, null);
        if (empty()) {
            front = node;
            rear = front;
        } else {
            // 改指针  赋值
            rear.next = node;
            rear = node;
        }
        size++;
        return true;
    }

    @Override
    public Object element() {
        checkEmpty();
        return front.element;
    }


    @Override
    public Object peek() {
        if (empty()) {
            return null;
        }
        return front.element;
    }

    @Override
    public Object poll() {
        if (empty()) {
            return null;
        }
        return moveFront();
    }

    @Override
    public Object remove() {
        checkEmpty();
        return moveFront();
    }

    /**
     * 移动头指针 并且 size--
     */
    private Object moveFront() {
        Node node = front;
        front = front.next;
        size--;
        return node.element;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkEmpty() {
        if (empty()) {
            try {
                throw new Exception("空队列");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean empty() {
        return size == 0;
    }

    class Node {
        private Object element;
        private Node next;

        public Node() {
        }

        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (empty()) {
            return "[]";
        } else {
            sb.append("[");
            sb.append(front.element);
            Node node = front;
            while (node.next != null) {
                sb.append(", ");
                node = node.next;
                sb.append(node.element);
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
