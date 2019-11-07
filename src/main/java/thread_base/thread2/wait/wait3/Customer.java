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
<<<<<<< HEAD
        while (true) {
=======
        while (true){
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
            clerk.takeOffproduct();
        }
    }
}
