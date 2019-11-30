package 结构型模型.适配器模式.类适配器;

/**
 * @Author whh
 */
public class Adapter extends Adaptee implements Target {

    public void request() {
        specificRequest();
    }

}
