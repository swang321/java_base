package other.代理模式;

/**
 * @Author whh
 * @data 2019/7/11 10:22
 */
public class Scalper implements Subject {

    private Subject subject;

    public Scalper(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sell() {
        subject.sell();
    }
}
