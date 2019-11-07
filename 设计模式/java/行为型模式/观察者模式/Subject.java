package 行为型模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标类
 *
 * @Author whh
 */
public abstract class Subject {

    /**
     * 定义一个观察者集合用于存储所有观察者对象
     */
    protected List<Observer> observers = new ArrayList<>();
    /**
     * 观察者状态
     */
    private int subjectState;

    public int getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(int subjectState) {
        this.subjectState = subjectState;
    }

    /**
     * 注册方法  用于观察者集合中添加一个观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 注销方法，用于在观察者集合中删除一个观察者
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 声明抽象通知方法
     */
    public abstract void notifyObserver();

}
