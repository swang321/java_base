package thread_base.thread2.wait.wait3;

/**
 * @Author whh
 */
public class Clerk {

    private int product;

    public Clerk() {
    }

    public Clerk(int product) {
        this.product = product;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    // 生产商送货的方法
    public synchronized void getProducts() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(Thread.currentThread().getName() + "成功送来第" + ++product + "号货物");
            notify();
        }
    }

    // 消费者取走货物的方法
    public synchronized void takeOffproduct() {
        if (product <= 0) {
            System.out.println("已缺货！！！");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "成功取走第" + product-- + "号货物");
            notifyAll();
        }
    }
}
