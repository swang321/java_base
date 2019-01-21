package thread.concurrent01;

/**
 * @Date: 2019/1/21 15:32
 * @Description: join()  join 方法
 * @Author admin
 */
public class ConcurrentMain04 {

    public static void main(String[] args) {

        Thread threadA = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程AAAAAA  ");
                super.run();
            }
        };


        Thread threadB = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程BBBBB  ");
                super.run();
            }
        };

        threadB.start();
        threadA.start();
        try {
            threadB.join();
            System.out.println(" 线程" + Thread.currentThread().getName() + "调用 join 方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
