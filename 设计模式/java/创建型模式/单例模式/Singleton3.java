package 创建型模式.单例模式;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * @Author whh
 */
public class Singleton3 {

    private volatile static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                instance = new Singleton3();
            }
        }
        return instance;
    }

}
