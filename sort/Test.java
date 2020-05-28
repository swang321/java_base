/**
 * @Author whh  2020/5/22 9:46
 */
public class Test {

    public static void main(String[] args) {

        int tt = tt();
        System.out.println(tt);

    }

    private static int tt() {
        int a = 1;
        try {
            a = 5;
            return a;
        } catch (Exception e) {
            a = 50;
            return a;
        } finally {
            a = 500;
            return a;
        }
    }

}
