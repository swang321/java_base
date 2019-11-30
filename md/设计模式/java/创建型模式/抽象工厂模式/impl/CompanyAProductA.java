package 创建型模式.抽象工厂模式.impl;

import 创建型模式.抽象工厂模式.interfaces.IProductA;

/**
 * @Author whh
 */
public class CompanyAProductA implements IProductA {
    public void getProductA() {
        System.out.println("公司A  生产 产品A");
    }
}
