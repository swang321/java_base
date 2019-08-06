package java_some;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列  生产消费模型 适合用 socket  读取  解析
 *
 * @Author whh  2019/8/6 16:49
 */
public class BlockQueueTest2 {

    private int queueSize = 10;

    private final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {

        BlockQueueTest2 blockQueueTest2 = new BlockQueueTest2();
        Producer producer = blockQueueTest2.new Producer();
        Consumer consumer = blockQueueTest2.new Consumer();

        producer.start();
        consumer.start();

        String aa = "Asd";

    }


    class Consumer extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
