package 行为型模式.策略模式;


/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Context context = new Context();

        ConcreteStrategyA concreteStateA = new ConcreteStrategyA();
        context.setStrategy(concreteStateA);
        context.algorithm();


    }

}
