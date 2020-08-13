package collection.map;

/**
 * @Author whh
 */
public class MyHashMap implements MyMap {

    /**
     * 创建   MyHashMap 时未指定初始化容量下得默认容量  16
     */
    static final int DEFAULT_CAPACITY = 1 << 4;

    /**
     * 转换成书得阈值  当链表长度到8得时候转换成树
     */
    static final int TREE_THRESHOLD = 8;

    /**
     * 当树的长度到6得时候转换成链表
     */
    static final int LIST_THRESHOLD = 8;

    /**
     * 当链表转换成树的时候 需要判断下数组的容量  当数组容量大于这个值时，才转换成树，
     * 否则 链表太长 由于数组容量太小导致的，则不转换成树，而是对数组扩容
     */
    static final int MIN_TREE_CAPACITY = 8;


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    /**
     * 实现数组中链接的数据结构
     */
    static class Node<K, V> implements MyMap.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        /**
         * 链表中当前节点的下一个节点
         */
        MyHashMap.Node<K, V> next;

        Node(int hash, K key, V value, MyHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }

}
