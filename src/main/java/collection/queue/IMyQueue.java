package collection.queue;

/**
 * @Date: 2019/1/9 14:26
 * @Description:
 * @Author admin
 */
public interface IMyQueue {

    /**
     * 插入元素到队尾，
     */
    boolean add(Object object);

    /**
     * 返回队头元素 ，但不删除 若队列为空抛出异常
     */
    Object element();

    /**
     * 移除队头元素 ，若队列为空返回null
     */
    Object poll();

    /**
     * 返回队头元素 ，若队列为空返回null
     */
    Object peek();

    /**
     * 移除队头元素  若队列为空抛出异常
     */
    Object remove();

    int size();

}
