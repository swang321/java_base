package aarandom;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author whh  2019/8/15 15:18
 */
public class Test2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCall myCall = new MyCall();
        FutureTask futureTask = new FutureTask<>(myCall);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 30) {
                Thread thread = new Thread(futureTask);
                thread.start();
            }
        }

        Object o = futureTask.get();
        System.out.println(o);
    }

}


class MyCall implements Callable {

    private int i = 0;

    @Override
    public Object call() {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            sum += i;
        }
        return sum;
    }
}