package other.动态代理;

/**
 * @Author whh
 * @data 2019/7/10 17:47
 */
public class Test {

    public static void main(String[] args) {

        IUserDao iUserDao = new UserDaoImpl();
        System.out.println(iUserDao.getClass());
        iUserDao.save();

        IUserDao proxyInstance = (IUserDao) new ProxyFactory(iUserDao).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.save();
    }

}
