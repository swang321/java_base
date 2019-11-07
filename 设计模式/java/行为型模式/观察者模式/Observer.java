package 行为型模式.观察者模式;

/**
 * 抽象观察者
 *
 * @Author whh
 */
public interface Observer {

    /**
     * 声明响应方法
     */
    void update(Subject subject);

}
