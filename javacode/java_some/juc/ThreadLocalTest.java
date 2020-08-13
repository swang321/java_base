package java_some.juc;

/**
 * @Author whh  2019/8/5 17:14
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };


    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }


    public static void main(String[] args) {

        ThreadLocal local = new ThreadLocal();

        ThreadLocalTest test = new ThreadLocalTest();
        TestClient t1=new TestClient(test);
        TestClient t2=new TestClient(test);
        TestClient t3=new TestClient(test);

        t1.start();
        t2.start();
        t3.start();

    }

    private static class TestClient extends Thread {
        private ThreadLocalTest threadLocalTest;

        public TestClient(ThreadLocalTest threadLocalTest) {
            this.threadLocalTest = threadLocalTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("name: " + Thread.currentThread().getName() + "num: " + threadLocalTest.getNextNum());
            }
        }
    }

}
