package javabase.jicheng;

/**
 * @Author whh
 */
public class Person1 {

    public void display() {
        System.out.println("play person ");
    }

    static void display(Person1 person) {
        person.display();
    }

}
