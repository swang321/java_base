package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author admin
 */
public class QueueTest {

    public static void main(String[] args) {

        Queue queue = new LinkedList();
        queue.add(0);
        queue.add(1);
        queue.add("Asd");
        System.out.println(queue.size());
        System.out.println(queue.element());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue);


        MyLinkedQueue myLinkedQueue = new MyLinkedQueue();
        myLinkedQueue.add(0);
        myLinkedQueue.add(1);
        myLinkedQueue.add("Asd");
        System.out.println(myLinkedQueue.size());
        System.out.println(myLinkedQueue.element());
        System.out.println(myLinkedQueue.poll());
        System.out.println(myLinkedQueue.peek());
        System.out.println(myLinkedQueue.remove());
        System.out.println(myLinkedQueue);


    }

}
