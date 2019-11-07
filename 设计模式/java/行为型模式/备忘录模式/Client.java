package 行为型模式.备忘录模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Originator originator = new Originator();
        System.out.println(originator.getState());
        originator.setState("状态1");
        System.out.println("初始状态:" + originator.getState());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.setState("状态2");
        System.out.println("修改后状态:" + originator.getState());
        originator.rectorMemento(caretaker.getMemento());
        System.out.println("撤銷后状态:" + originator.getState());

    }

}
