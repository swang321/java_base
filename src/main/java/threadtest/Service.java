package threadtest;

/**
 * @Author whh
 */
public class Service {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName(i);

            UserTask userTask = new UserTask(user);
            MyThreadPool.BLOCKINGQUEUE.add(userTask);
        }
        MyThreadPool.execute();

//        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
//        for (int i = 0; i < 2; i++) {
//            queue.add(i);
//        }
//
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.size());
    }
}
