package 创建型模式.抽象工厂模式.impl;

import 创建型模式.抽象工厂模式.interfaces.IProductB;

/**
 * @Author whh
 */
public class CompanyAProductB implements IProductB {
    public void getProductB() {
        System.out.println("公司A  生产 产品B");
    }
}
