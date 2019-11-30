package 行为型模式.观察者模式;

/**
 * 具体目标类
 *
 * @Author whh
 */
public class ConcreteSubject extends Subject {


    @Override
    public void notifyObserver() {
        // 遍历观察者集合，调用每一个观察者的响应方法
        for (Object obs : observers) {
            ((Observer) obs).update(this);
        }
    }
}
