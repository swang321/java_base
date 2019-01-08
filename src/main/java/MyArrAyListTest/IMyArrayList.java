package MyArrAyListTest;

/**
 * @Date: 2019/1/2 11:49
 * @Description:
 * @Author admin
 */
public interface IMyArrayList {

    /**
     * 返回 size
     */
    int size();

    /**
     * 添加元素
     */
    void add(Object obj);

    /**
     * 添加元素到指定位置
     */
    void add(int index, Object obj);

    /**
     * 判断是否为null
     */
    boolean isEmpty();

    /**
     * 获取 索引 index得值
     */
    Object get(int index);


}
