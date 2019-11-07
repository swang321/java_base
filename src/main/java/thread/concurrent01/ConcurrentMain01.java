package thread.concurrent01;

/**
 * @Date: 2019/1/21 14:12
 * @Description:
 * @Author admin
 */
public class ConcurrentMain01 {

    private static String resource_a = "A";
    private static String resource_b = "B";


    public static void main(String[] args) {
        deadLock();
    }

    static void deadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a) {
                    System.out.println("get resource a");
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource_b) {
                    System.out.println("get resource b");
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b) {
                    System.out.println("get resource b");
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource_a) {
                    System.out.println("get resource a");
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}
