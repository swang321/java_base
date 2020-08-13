package thread_base.thhread1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author whh
 */
public class Thread3 {

    public static void main(String[] args) {
        //创建有返回值的任务
        Callable<String> callable = new MyThread3();
        FutureTask<String> task = new FutureTask<>(callable);

        // 创建开启线程
        new Thread(task).start();
        String result = null;

        try {
            // 调用get()阻塞主线程，并获取返回值
            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(result);

    }

}

class MyThread3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "this is return string";
    }
}