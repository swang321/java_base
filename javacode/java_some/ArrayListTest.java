package java_some;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author whh  2019/8/8 10:29
 */
public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        Collections.binarySearch(list, 3);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            map.put(i, i);
        }
    }

}
