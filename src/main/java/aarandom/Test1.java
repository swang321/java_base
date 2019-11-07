package aarandom;

/**
 * @Author whh  2019/8/15 15:02
 */
public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException {

        Test1 test1 = new Test1();
        Class class1 = test1.getClass();
        System.out.println(class1);
        Class<Test1> test2 = Test1.class;
        System.out.println(test2);
        Class<?> test3 = Class.forName("aarandom.Test1");
        System.out.println(test3);


        System.out.println(class1.getName());
        System.out.println(class1.getSimpleName());

    }

}
