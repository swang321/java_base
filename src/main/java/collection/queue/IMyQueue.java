package collection.queue;

/**
 * @Date: 2019/1/9 14:26
 * @Description:
 * @Author admin
 */
public interface IMyQueue {

    boolean add(Object object);

    Object element();

    boolean offer(Object object);

    Object peek();

    Object poll();

    Object remove();

}
