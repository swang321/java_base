package 创建型模式.抽象工厂模式.impl;

import 创建型模式.抽象工厂模式.interfaces.Factory;
import 创建型模式.抽象工厂模式.interfaces.IProductA;
import 创建型模式.抽象工厂模式.interfaces.IProductB;

/**
 * @Author whh
 */

public class FactoryCompanyA implements Factory {
    public IProductA getProductA() {
        return new CompanyAProductA();
    }

    public IProductB getProductB() {
        return new CompanyAProductB();
    }
}
