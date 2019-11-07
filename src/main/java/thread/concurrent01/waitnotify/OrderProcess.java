package thread.concurrent01.waitnotify;

import java.util.LinkedList;

/**
 * @Author whh
 */
public class OrderProcess {


    private static final int MAXZIE = 15;

    private static final LinkedList list = new LinkedList();

    public void addOrder(Order order) {

        synchronized (list) {
            if (list.size() >= MAXZIE) {
                System.out.println("list(" + list.size() + ") 已经满了！");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(order);
            System.out.println("订单已提交了！");
            list.notify();
        }

    }

    public void getOrder() {
        synchronized (list) {
            if (list.isEmpty()) {
                try {
                    System.out.println("暂时无订单");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Order order = (Order) list.getFirst();
            list.remove(order);
            System.out.println("从list(" + list.size() + ")取订单成功！");
            list.notify();

        }
    }

}
