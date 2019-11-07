package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2019/1/21 10:36
 * @Description:
 * @Author admin
 */
public class CreateExecutorsMain02 {

    public static void main(String[] args) {

        createExecutor();

    }

    private static void createExecutor() {

        ExecutorService service = Executors.newFixedThreadPool(5);
        TaskCallable task = new TaskCallable();

        service.submit(task);

        service.submit(task);

        service.shutdown();


    }

    static class TaskCallable implements Callable {

        @Override
        public Object call() throws Exception {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程回调方法" + i);
            }
            System.out.println("---------------------------");
            return null;
        }
    }

}
