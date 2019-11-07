package tests;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author whh  2019/10/22 17:02
 */
public class TTT {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
        }

        for (String s : list) {
            MyRunner myRunner = new MyRunner(s);
            ThreadPoolService.execute(myRunner);
        }

    }
}
