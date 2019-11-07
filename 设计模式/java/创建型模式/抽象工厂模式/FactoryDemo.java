package 创建型模式.抽象工厂模式;

import 创建型模式.抽象工厂模式.impl.FactoryCompanyA;
import 创建型模式.抽象工厂模式.impl.FactoryCompanyB;

/**
 * @Author whh
 */
public class FactoryDemo {

    public static void main(String[] args) {

        FactoryCompanyA factoryCompanyA = new FactoryCompanyA();
        factoryCompanyA.getProductA().getProductA();
        factoryCompanyA.getProductB().getProductB();

        FactoryCompanyB factoryCompanyB = new FactoryCompanyB();
        factoryCompanyB.getProductA().getProductA();
        factoryCompanyB.getProductB().getProductB();
    }
}
//   创建 产品 空调（A）  产品 洗衣机（B） 接口
//   海尔公司生产 A    格力公司生产 A
//   海尔公司生产 B    格力公司生产 B
//   创建工厂 A   B
//   海尔 实现工厂 生产 A B
//   格力 实现工厂 生产 A B