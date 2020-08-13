package java_some;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author whh  2019/8/6 14:07
 */
public class Queue {

    public static void main(String[] args) {

        // 阻塞队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        ArrayBlockingQueue<Integer> arrayBlockingQueue1 = new ArrayBlockingQueue<>(10, false, Lists.newArrayList(1, 2, 3));
        System.out.println(arrayBlockingQueue1);

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();

        DelayQueue delayQueue = new DelayQueue();


        // 非阻塞队列
        PriorityQueue priorityQueue = new PriorityQueue();

        LinkedList<Integer> linkedList = new LinkedList<>();

        // 将元素e插入到队列末尾,如果插入成功，则返回true；如果插入失败（即队列已满），则返回false
        linkedList.offer(1);
        linkedList.offer(2);

        //移除并获取队首元素，若成功，则返回队首元素；否则返回null；
        linkedList.poll();
        System.out.println(linkedList);

        //获取队首元素，若成功，则返回队首元素；否则返回null
        Integer headNode = linkedList.peek();
        System.out.println(headNode);

    }


}
