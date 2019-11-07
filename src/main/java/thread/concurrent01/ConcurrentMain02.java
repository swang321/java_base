package thread.concurrent01;

import java.util.concurrent.*;

/**
 * @Date: 2019/1/21 15:14
 * @Description: 新建线程三种示例
 * @Author admin
 */
public class ConcurrentMain02 {

    public static void main(String[] args) {

        // 1.继承Thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("继承Thread");
                super.run();
            }
        };
        // 2.实现Runnable
        Thread thread1 = new Thread(() -> System.out.println("实现Runnable"));

        // 3.实现callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(() -> "实现callable接口");

        String result;
        try {

            result = future.get();
            System.out.println(result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
