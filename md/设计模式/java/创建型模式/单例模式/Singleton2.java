package 创建型模式.单例模式;

/**
 * 饿汉式
 * <p>
 * 优点
 * 没有加锁，执行效率会提高。
 * 在类加载的同时已经创建好一个静态对象，调用时反应速度快 。
 * 缺点
 * 类加载时就初始化，浪费内存。
 *
 * @Author whh
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    public Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
