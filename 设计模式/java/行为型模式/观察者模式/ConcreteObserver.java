package 行为型模式.观察者模式;

/**
 * 具体观察者
 *
 * @Author whh
 */
public class ConcreteObserver implements Observer {
    /**
     * 观察者名称
     */
    String name;
    /**
     * 观察者状态
     */
    int observerState;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        observerState = subject.getSubjectState();
        System.out.println("update oberserver[" + name + "] state:" + observerState);
    }
}
