package collection.linkedlist;

/**
 * @Author admin
 */
public interface IMyLinkedList {

    /**
     * 返回 size
     */
    int size();

    /**
     * 在尾部添加元素
     */
    void add(Object obj);

    /**
     * 在此列表中指定的位置插入指定的元素。移动当前在该位置处的元素（如果有），所有后续元素都向右移（在其索引中添加 1）。
     */
    void add(int index, Object obj);

    /**
     * 返回此列表中指定位置处的元素。
     */
    Object get(int index);

    /**
     * 将该元素插入此列表的开头。
     */
    void push(Object obj);

    /**
     * 返回此列表的第一个元素。
     */
    Object getFirst();

    /**
     * 返回此列表的最后一个元素。
     */
    Object getLast();

}
