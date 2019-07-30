package other.动态代理;

import java.lang.reflect.Proxy;

/**
 * @Author whh
 * @data 2019/7/10 17:42
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开始事务111");
                    //执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务111");
                    return returnValue;
                }
        );
    }

}
