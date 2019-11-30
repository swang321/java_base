package 创建型模式.抽象工厂模式.impl;

import 创建型模式.抽象工厂模式.interfaces.IProductB;

/**
 * @Author whh
 */
public class CompanyBProductB implements IProductB {
    public void getProductB() {
        System.out.println("公司B  生产 产品B");
    }
}
