package tests;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author whh  2019/10/22 16:10
 */
class MyRunner implements Runnable {

    private String msg;

    public MyRunner(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        if (!msg.contains("3")) {
            System.out.println(msg);
        }
    }


}