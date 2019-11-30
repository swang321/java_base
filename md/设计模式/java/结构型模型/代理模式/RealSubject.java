package 结构型模型.代理模式;

/**
 * 真实主题角色
 *
 * @Author whh
 */
public class RealSubject extends Subject {

    @Override
    public void request() {
        System.out.println("realSubject");
    }

}
