package collection.arraylist;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author whh
 */
public class Test {

    public static void main(String[] args) {

        String[] availableIDs = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(availableIDs));

        TimeZone timeZone = TimeZone.getTimeZone(String.valueOf(11));
        System.out.println(timeZone);

        List l = new ArrayList();
//        l.forEach();

        Map map = new HashMap<>(15);
        for (int i = 0; i < 30; i++) {
            map.put(i, i);
        }
        System.out.println(map);

//        TheadLocal local=new ThreadLocal<>()


    }
}
