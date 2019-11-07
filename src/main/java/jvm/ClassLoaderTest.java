package jvm;

/**
 * @Author whh
 * @Time 2019/7/23 9:42
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {


        System.out.println(Class.forName("java.lang.String").getClassLoader());
        System.out.println(Class.forName("jvm.ClassLoaderTest").getClassLoader());

//        reference

    }

}

//  基本数据类型使用根类加载器加载的，因此本类中java.lang.String获取类加载器返回的结果应该是null