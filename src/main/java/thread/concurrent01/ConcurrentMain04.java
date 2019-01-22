package thread.concurrent01;

/**
 * @Date: 2019/1/21 15:32
 * @Description: join()  join 方法
 * @Author admin
 */
public class ConcurrentMain04 implements Runnable {

    public static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new ConcurrentMain04();
        Thread t = new Thread(r);
        t.start();

        // 没有 添加   t.join()  输出是  0
        // 添加   t.join()   输出是   5
        //  join() 方法 是 谁调用 join() 方法  谁就停下来  等其他执行完毕  自己再执行

        t.join();
        System.out.println(a);
    }

    @Override
    public void run() {
        for (int k = 0; k < 5; k++) {
            a = a + 1;
        }
    }

}
