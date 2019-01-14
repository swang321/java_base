package collection.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Date: 2019/1/14 14:51
 * @Description:
 * @Author admin
 */
public class SetTest {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<Integer>();
        set.add(4);
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(22);
        set.add(11);
        set.add(33);
        System.out.println(set);


    }

}
