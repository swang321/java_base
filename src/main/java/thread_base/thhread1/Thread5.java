package thread_base.thhread1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author whh
 */
public class Thread5 {

    public static void main(String[] args) {

        // 创建线程执行器
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 创建 future 类型得集合
        ArrayList<Future<Integer>> futures = new ArrayList<>();

        // 将    Executor 提交得任务 得返回值添加到集合中
        for (int i = 0; i < 10; i++) {
            futures.add(threadPool.submit(new MyThread5()));
        }

        //遍历集合取出数据
        for (Future<Integer> future : futures) {
            try {
                // 调用get()阻塞主线程，并获取返回值
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                threadPool.shutdown();
            }
        }
    }
}

class MyThread5 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(100);
    }
}
