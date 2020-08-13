package collection.linkedlist;

import collection.myexception.MyException;

/**
 * @Author admin
 */
public class MyLinkedList implements IMyLinkedList {

    private int size;

    private Node<Object> first;

    private Node<Object> last;

    private int modCount;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object obj) {
        Node<Object> lastNode = last;
        Node<Object> newNode = new Node<>(lastNode, obj, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        addCount();
    }

    @Override
    public void add(int index, Object obj) {
        checkIndex(index);
        Node<Object> node = getNode(index);
        if (index == size) {
            add(node);
        } else {
            addLinkedIndex(obj, node);
        }
    }

    private void addLinkedIndex(Object obj, Node<Object> node) {
        Node<Object> pre = node.pre;
        Node<Object> newNode = new Node<Object>(pre, obj, node);
        if (pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
        addCount();
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNode(index).item;
    }

    private Node<Object> getNode(int index) {
        Node<Object> node = first;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                break;
            }
            node = node.next;
        }
        return node;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new MyException("超出范围", index);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void push(Object obj) {
        Node<Object> firstNode = first;
        Node<Object> newFirst = new Node<Object>(null, obj, firstNode);
        first = newFirst;
        if (firstNode == null) {
            last = newFirst;
        } else {
            firstNode.pre = first;
        }
        addCount();
    }

    @Override
    public Object getFirst() {
        if (first != null) {
            return first.item;
        }
        return null;
    }

    @Override
    public Object getLast() {
        if (last != null) {
            return last.item;
        }
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;

        Node(Node<E> pre, E item, Node<E> next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (last == null) {
            return "[]";
        } else {
            sb.append("[");
            Node<Object> node = first;
            for (int i = 0; i < size; i++) {
                sb.append(node.item);
                if (node.next != null) {
                    sb.append(", ");
                    node = node.next;
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    private void addCount() {
        size++;
        modCount++;
    }
}
