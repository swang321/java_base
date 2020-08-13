package thread_base.thread2.wait.wait3;

/**
 * @Author whh
 */
public class Product implements Runnable {

    private Clerk clerk;

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Product() {
    }

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.getProducts();
        }
    }
}
