package 结构型模型.适配器模式.对象适配器;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();

    }
}
