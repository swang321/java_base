package thread.demo01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Date: 2019/1/21 11:17
 * @Description:
 * @Author admin
 */
public class ThreadPoolDemo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        // 实例任务对象
        MyCallable01 myCallable01 = new MyCallable01(100, 200);
        MyCallable01 myCallable02 = new MyCallable01(10, 20);

        //提交返回 Future 对象
        Future future = service.submit(myCallable01);
        // get()方法  获取结果
        Object result = future.get();
        System.out.println("sum=" + result);

        //再演示
        future = service.submit(myCallable02);
        result = future.get();
        System.out.println("sum=" + result);
        //关闭线程池(可以不关闭)


        service.shutdown();
    }

}
