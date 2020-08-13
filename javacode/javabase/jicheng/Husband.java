package javabase.jicheng;

import javabase.fengzhuang.Wife;

/**
 * @Author whh
 */
public class Husband extends Person {

    private Wife wife;

    Husband() {
        super("whh");
        System.out.println("Husband Constructor...");
    }

    public static void main(String[] args) {

        Husband husband = new Husband();


    }
}
