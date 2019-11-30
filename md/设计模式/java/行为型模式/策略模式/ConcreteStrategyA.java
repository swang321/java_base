package 行为型模式.策略模式;

/**
 * @Author whh
 */
public class ConcreteStrategyA extends Strategy {

    /**
     * 算法的具体实现
     */
    @Override
    public void algorithm() {
        System.out.println("使用的策略A");
    }

}
