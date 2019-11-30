package 结构型模型.代理模式;

/**
 * 代理主题角色
 *
 * @Author whh
 */
public class Proxy extends Subject {

    private RealSubject realSubject = new RealSubject();

    @Override
    public void request() {

        preRequest();
        realSubject.request();
        afterRequest();

    }

    private void afterRequest() {
        System.out.println("after request");
    }

    private void preRequest() {
        System.out.println("pre request");
    }


}
