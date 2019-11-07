package java_some;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @Author whh  2019/8/6 10:08
 */
public class ATest {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList 进行1000000次插入操作耗时：" + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            vector.add(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("vector 进行1000000次插入操作耗时：" + (end2 - start1) + "ms");

    }

}
