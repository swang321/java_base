package other.代理模式;

/**
 * @Author whh
 * @data 2019/7/11 10:21
 */
public class Station implements Subject {
    @Override
    public void sell() {
        System.out.println("买票");
    }

    public void change() {
        System.out.println("改签");
    }

}
