package 行为型模式.状态模式;

/**
 * 抽象状态类
 *
 * @Author whh
 */
public abstract class State {

    /**
     * 声明抽象业务方法，不同的具体状态类可以不同的实现
     */
    public abstract void handle(Context context);

}
