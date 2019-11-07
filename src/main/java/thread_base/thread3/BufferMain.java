package thread_base.thread3;

/**
 * @Author whh
 */
public class BufferMain {
    private static ConditionBuffer cb = new ConditionBuffer();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new PutThread("put" + i, i).start();
            new TakeThread("take " + i).start();
        }
    }

    static class TakeThread extends Thread {
        TakeThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1);
                cb.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class PutThread extends Thread {
        private int num;

        PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1);
                cb.put(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



