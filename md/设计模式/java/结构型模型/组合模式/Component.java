package 结构型模型.组合模式;

/**
 * @Author whh
 */
public abstract class Component {

    /**
     * 增加成员
     */
    public abstract void add(Component component);

    /**
     * 删除成员
     */
    public abstract void remove(Component component);

    /**
     * 获取成员
     */
    public abstract Component getChild(int i);

    /**
     * 业务方法
     */
    public abstract void operation();
}
