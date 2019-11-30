package 创建型模式.工厂方法模式;

import 创建型模式.工厂方法模式.impl.FactoryA;
import 创建型模式.工厂方法模式.impl.FactoryB;
import 创建型模式.工厂方法模式.interfaces.IProduct;

/**
 * @Author whh
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        FactoryA factoryA = new FactoryA();
        IProduct product = factoryA.getProduct();
        product.getProduct();


        FactoryB factoryB = new FactoryB();
        IProduct productB = factoryB.getProduct();
        productB.getProduct();
    }
}
//  场景
//  JDBC切换数据库产品