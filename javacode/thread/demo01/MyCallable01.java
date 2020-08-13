package thread.demo01;

import java.util.concurrent.Callable;

/**
 * @Date: 2019/1/21 11:18
 * @Description:
 * @Author admin
 */
public class MyCallable01 implements Callable {

    private int x;
    private int y;

    public MyCallable01() {
    }

    public MyCallable01(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object call() throws Exception {
        return x + y;
    }
}
