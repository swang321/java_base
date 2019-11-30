package 结构型模型.适配器模式.对象适配器;

/**
 * @Author whh
 */
public class Adapter extends Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRquest();
    }
}
