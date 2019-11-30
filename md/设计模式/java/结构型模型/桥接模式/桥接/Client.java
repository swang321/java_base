package 结构型模型.桥接模式.桥接;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {


        Abstraction abstraction = new RefinedAbstraction();
        abstraction.implementor = new CreateImplementorA();
        abstraction.operation();

        abstraction.implementor = new CreateImplementorB();
        abstraction.operation();


    }

}
