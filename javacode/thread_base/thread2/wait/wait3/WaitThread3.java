package thread_base.thread2.wait.wait3;

/**
 * @Author whh
 */
public class WaitThread3 {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Product product = new Product(clerk);
        Customer customer = new Customer(clerk);

        Thread t1 = new Thread(product, "生产者");
        Thread t2 = new Thread(customer, "消费者");

        t1.start();
        t2.start();

    }

}
