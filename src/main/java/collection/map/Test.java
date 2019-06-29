package collection.map;

/**
 * @Author whh
 */
public class Test {

    private static int k = 0;

    public static void main(String[] args) {

        test(4);

    }

    private static void test(int i) {
        if (k == i) {
            return;
        }
        k++;
        for (int j = 0; j < i; j++) {
            test(i);
        }

    }

}
