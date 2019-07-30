package other.代理模式;

/**
 * @Author whh
 * @data 2019/7/11 10:22
 */
public class ProxyTest {


    public static void main(String[] args) {


        Station subject = new Station();
        Scalper scalper = new Scalper(subject);
        scalper.sell();

    }


}
