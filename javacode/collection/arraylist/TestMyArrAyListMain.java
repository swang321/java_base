package collection.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author admin
 */
public class TestMyArrAyListMain {
    public static void main(String[] args) {

        MyArrAyList myList = new MyArrAyList();
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println(myList.isEmpty());
        myList.add(1, 100);
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println(myList.isEmpty());
        System.out.println(myList.get(12));


        List list = new ArrayList();


    }
}
