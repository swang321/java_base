package javabase.equals;


/**
 * @Author whh
 */
public class Test2 {


    public static void main(String[] args) {

        Cats c1 = new Cats(1, 1, 1);
        Cats c2 = new Cats(1, 1, 1);

        //false
        System.out.println("c1==c2的结果是：" + (c1 == c2));
        //false
        System.out.println("c1.equals(c2)的结果是：" + c1.equals(c2));

    }

    private static class Cats {
        int a, b, c;

        Cats(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

}
