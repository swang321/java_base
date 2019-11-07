package 行为型模式.状态模式;

/**
 * 抽象状态类 A
 *
 * @Author whh
 */
public class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 A.");
    }
}
