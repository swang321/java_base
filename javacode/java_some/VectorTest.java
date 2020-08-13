package java_some;

import java.util.Vector;

/**
 * @Author whh  2019/8/6 10:38
 */
public class VectorTest {

    static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 10; i++) {
                vector.add(i);

                new Thread(() -> {
                    for (int j = 0; j < vector.size(); j++) {
                        vector.remove(j);
                    }
                }).start();

                new Thread(() -> {
                    for (int j = 0; j < vector.size(); j++) {
                        vector.get(j);
                    }
                }).start();

            }
            while (Thread.activeCount() > 10) {

            }

        }


    }

}
