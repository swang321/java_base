package other.静态代理;

/**
 * @Author whh
 * @data 2019/7/11 10:59
 */
public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    @Override
    public void sayHello() {
        hello.sayHello();
    }
}
