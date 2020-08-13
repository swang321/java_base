package java_some.thread;

/**
 * @Author whh  2019/8/8 16:51
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。。");
    }
}


