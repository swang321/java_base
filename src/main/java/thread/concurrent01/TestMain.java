package thread.concurrent01;

/**
 * @Author whh
 */


public class TestMain {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread threads = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    System.out.println("Asd");
                }
            }
        });
        threads.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }


}


