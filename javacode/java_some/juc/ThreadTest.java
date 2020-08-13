package java_some.juc;

/**
 * @Author whh  2019/8/5 15:04
 */
public class ThreadTest {


    public static void main(String[] args) {

        final InsertData insertData = new InsertData();
        new Thread(() -> insertData.insert()).start();

        new Thread(() -> insertData.insert1()).start();

//        System.out.println(insertData.list);
    }

}

class InsertData {

    public synchronized void insert() {
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert over");
    }

    public synchronized static void insert1() {

        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }

}