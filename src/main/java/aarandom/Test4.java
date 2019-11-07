package aarandom;

/**
 * @Author whh  2019/8/15 16:17
 */
public class Test4 {

    public static void main(String[] args) {
        methods();
    }

    private static void methods() {
        synchronized (Test4.class) {
            System.out.println("---------");
        }
    }

}
