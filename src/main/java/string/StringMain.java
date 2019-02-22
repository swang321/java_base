package string;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2019/1/22 10:37
 * @Description:
 * @Author admin
 */
public class StringMain {

    public static void main(String[] args) {

        String str = "ABCDEFG";

        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());

        char[] chars = str.toCharArray();
        System.out.println(chars.length);


        SortedMap sortedMap = Collections.synchronizedSortedMap(new TreeMap());
        sortedMap.put("a", "2");
        sortedMap.put("c", "1");
        sortedMap.put("b", "3");
        System.out.println(sortedMap);

        ReentrantLock reentrantLock = new ReentrantLock();

    }


}
