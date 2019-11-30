package 行为型模式.观察者模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();

        Observer observerA = new ConcreteObserver("A");
        Observer observerB = new ConcreteObserver("B");
        subject.attach(observerA);
        subject.attach(observerB);

        subject.setSubjectState(1);
        subject.notifyObserver();

        subject.detach(observerB);
        subject.setSubjectState(2);
        subject.notifyObserver();


    }

}
