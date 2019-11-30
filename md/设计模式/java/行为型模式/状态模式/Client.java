package 行为型模式.状态模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Context context = new Context();
        ConcreteStateA state = new ConcreteStateA();
        context.setState(state);
        context.request();

        context.changeValue(1);
        context.request();

        context.changeValue(0);
        context.request();

    }

}
