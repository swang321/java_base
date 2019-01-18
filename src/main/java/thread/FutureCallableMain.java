package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Date: 2019/1/18 16:00
 * @Description:
 * @Author admin
 */
public class FutureCallableMain implements Callable {

    public static void main(String[] args) {

        FutureCallableMain futureCallableMain = new FutureCallableMain();

        FutureTask futureTask = new FutureTask(futureCallableMain);

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值:  " + i);
            if (i == 5) {
                new Thread(futureTask, "有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        return i;
    }
}
