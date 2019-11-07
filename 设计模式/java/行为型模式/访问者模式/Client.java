package 行为型模式.访问者模式;

import java.util.Random;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        ObjectStruture objectStruture = new ObjectStruture();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(100);
            if (a > 50) {
                System.out.println(a);
                objectStruture.addElement(new ConcreteElementA());
            } else {
                System.out.println(a);
                objectStruture.addElement(new ConcreteElementB());
            }
        }
        objectStruture.accept(new ConcreteVisitorA());
    }

}
