package 行为型模式.策略模式;

/**
 * 环境类
 *
 * @Author whh
 */
public class Context {

    /**
     * 维持一个对抽象策略类的引用
     */
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略类
     */
    public void algorithm() {
        strategy.algorithm();
    }

}
