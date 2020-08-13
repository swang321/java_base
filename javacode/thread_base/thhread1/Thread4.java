package thread_base.thhread1;

import java.util.concurrent.*;

/**
 * @Author whh
 */
public class Thread4 {
    public static void main(String[] args) {

        // 创建有返回值的线程任务
        Callable<String> callable = new MyThread4();
        // 创建线程执行器
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //通过线程执行器执行callable，并通过future获取返回结果
        Future<String> future = threadPool.submit(callable);
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        System.out.println(result);
    }
}

class MyThread4 implements Callable {
    @Override
    public Object call() throws Exception {
        return "return string";
    }
}



