package thread_base.thread2.wait.wait3;

/**
 * @Author whh
 */
public class Customer implements Runnable {

    private Clerk clerk;

    public Customer() {
    }

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.takeOffproduct();
        }
    }
}
