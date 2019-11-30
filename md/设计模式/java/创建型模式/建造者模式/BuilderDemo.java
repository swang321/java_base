package 创建型模式.建造者模式;

import 创建型模式.建造者模式.cretebuilder.CreteBuilder1;
import 创建型模式.建造者模式.cretebuilder.CreteBuilder2;
import 创建型模式.建造者模式.director.Director;
import 创建型模式.建造者模式.entity.Product;

/**
 * @Author whh
 */
public class BuilderDemo {

    public static void main(String[] args) {


        CreteBuilder1 creteBuilder1 = new CreteBuilder1();
        Director director = new Director(creteBuilder1);
        Product product = director.construct();
        System.out.println(product.toString());


        CreteBuilder2 creteBuilder2 = new CreteBuilder2();
        Director director2 = new Director(creteBuilder2);
        Product product2 = director2.construct();
        System.out.println(product2.toString());

    }
}
