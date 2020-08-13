package other.静态代理;

/**
 * @Author whh
 * @data 2019/7/11 11:00
 */
public class Test {

    public static void main(String[] args) {

        Hello hello = new HelloProxy();


        hello.sayHello();


    }

}
