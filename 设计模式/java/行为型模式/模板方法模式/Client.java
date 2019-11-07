package 行为型模式.模板方法模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        AbstractClass abstractClass;

        abstractClass = new ConocreClassA();
        abstractClass.templateMethod();

        System.out.println("------");

        abstractClass = new ConocreClassB();
        abstractClass.templateMethod();

    }

}
