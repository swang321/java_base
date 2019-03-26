package tests;

import java.util.HashMap;

/**
 * @Author whh
 */
public class TestMain {

    public static void main(String[] args) {

//        System.out.println("true&true=  "+(true&true));
//        System.out.println("true&false= "+(true&false));
//        System.out.println("false&false=    "+(false&false));
//        System.out.println("false&true=    "+(false&true));
//        System.out.println();
//        System.out.println("true&&true= "+(true&&true));
//        System.out.println("true&&false=    "+(true&&false));
//        System.out.println("false&&false=   "+(false&&false));
//        System.out.println("false&&true=   "+(false&&true));
//        System.out.println();
        int i = 0;
        System.out.println(false & ++i == 0);
        System.out.println(i);
        i = 0;
        System.out.println(true & ++i == 0);
        System.out.println(i);
        System.out.println("----------");
        i = 0;
        System.out.println(false && ++i == 0);
        System.out.println(i);
        i = 0;
        System.out.println(true && ++i == 0);
        System.out.println(i);
        System.out.println("----------");
        System.out.println("5&3=" + (5 & 3));



        HashMap<Integer, Integer> mapLevelThird = new HashMap<>(16);

    }

}
