package 结构型模型.适配器模式.类适配器;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Target target = new Adapter();
        target.request();

    }

}
