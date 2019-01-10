package collection.test;

import collection.linkedlist.MyLinkedList;

import java.util.LinkedList;

/**
 * @Date: 2019/1/7 15:51
 * @Description:
 * @Author admin
 */
public class TestMyLinkedListMain {
    public static void main(String[] args) {


        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println("---------");

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.push(12);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());

        myLinkedList.add(0, 66);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));


    }
}
