package collection.fail_fast;

import java.util.ListIterator;
import java.util.Vector;

/**
 * @Author whh
 */
public class Test1 {


    @org.junit.Test
    public void test() {
        try {
            // 测试迭代器的remove方法修改集合结构会不会触发checkForComodification异常
            ItrRemoveTest();
            System.out.println("----分割线----");
            // 测试集合的remove方法修改集合结构会不会触发checkForComodification异常
            ListRemoveTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 测试迭代器的remove方法修改集合结构会不会触发checkForComodification异常
    private void ItrRemoveTest() {
        Vector list = new Vector<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            //迭代器的remove方法修改集合结构
            itr.remove();
        }
    }

    // 测试集合的remove方法修改集合结构会不会触发checkForComodification异常
    private void ListRemoveTest() {
        Vector list = new Vector<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            //集合的remove方法修改集合结构
            list.remove("3");
        }
    }

}
