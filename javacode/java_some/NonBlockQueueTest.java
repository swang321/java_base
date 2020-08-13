package java_some;

import java.util.PriorityQueue;

/**
 * @Author whh  2019/8/6 16:22
 */
public class NonBlockQueueTest {

    private int queueSize = 10;

    private final PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    public static void main(String[] args) {

        NonBlockQueueTest nonBlockQueueTest = new NonBlockQueueTest();
        Producer producer = nonBlockQueueTest.new Producer();
        Consumer consumer = nonBlockQueueTest.new Consumer();

        producer.start();
        consumer.start();

    }

    class Consumer extends Thread {
        @Override
        public void run() {

            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println("队列空 等待数据");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    queue.notify();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("从队列取走一个元素: " + poll + " 队列剩余" + queue.size() + "个元素");
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        System.out.println("队列满了 等待有空余空间");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                }
            }
        }
    }

}
