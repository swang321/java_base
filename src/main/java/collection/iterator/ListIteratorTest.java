package collection.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author whh
 */
public class ListIteratorTest {

    public static void main(String[] args) {

        List list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator iterator = list.listIterator();
        System.out.println("--------------------向下遍历--------------------");
        while (iterator.hasNext()) {
            int nextIndex = iterator.nextIndex();
            String next = (String) iterator.next();
            //int previousIndex = iterator.previousIndex();
            //  前一个元素的索引"+previousIndex*
            System.out.println("当前元素："+next+"，当前元素索引："+nextIndex);
        }
        System.out.println("--------------------向上遍历--------------------");
        while (iterator.hasPrevious()) {
            int previousIndex = iterator.previousIndex();
            String previous = (String) iterator.previous();
            System.out.println("当前元素："+previous+"，当前元素索引："+previousIndex);
        }
        System.out.println("-----------测试set()和listIterator(n)----------");
        System.out.println(list);
        iterator = list.listIterator(3);
        while(iterator.hasNext()){
            iterator.next();
            iterator.set("5");
        }
        System.out.println(list);

    }

}
