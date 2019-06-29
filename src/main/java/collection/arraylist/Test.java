package collection.arraylist;

/**
 * @Author whh
 */
public class Test {

    public static void main(String[] args) {

        new  Thread(()-> System.out.println("线程111111111111111"),"111111111111").start();

        new  Thread(()-> System.out.println("线程222222222222222"),"222222222222").start();

        System.out.println("000000000000000");

    }
}
