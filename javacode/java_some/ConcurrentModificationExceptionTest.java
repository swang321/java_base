package java_some;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author whh  2019/8/6 11:04
 */
public class ConcurrentModificationExceptionTest {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 2) {
//                list.remove(next);
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
