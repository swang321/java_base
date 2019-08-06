package java_some;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author whh  2019/8/6 11:04
 */
public class ConcurrentModificationExceptionTest1 {

    static ArrayList<Integer> list = Lists.newArrayList(1,2,3,4,5);

    public static void main(String[] args) {
        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                System.out.println(next);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next == 2) {
                    iterator.remove();
                }
            }
        }).start();


    }
}
