package thread.concurrent01;

import java.util.concurrent.*;

/**
 * @Date: 2019/1/21 15:14
 * @Description: 示例
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
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现Runnable");
            }
        });

        // 3.实现callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "实现callable接口";
            }
        });

        String result = null;
        try {

            result = future.get();
            System.out.println(result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
