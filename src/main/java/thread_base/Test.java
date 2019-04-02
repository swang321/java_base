package thread_base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author whh
 */
public class Test {

    static Map<Integer, Integer> map = new HashMap<>(16);

    public static void main(String[] args) {
        map.put(1, 1);
        map.put(2, 2);

        ReadMapThread rm = new ReadMapThread();

        Thread t1 = new Thread(rm);
        Thread t2 = new Thread(rm);
        Thread t3 = new Thread(rm);
        Thread t4 = new Thread(rm);
        Thread t5 = new Thread(rm);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    static class ReadMapThread implements Runnable {
        @Override
        public void run() {
            System.out.println(map.get(1));
        }
    }
}



