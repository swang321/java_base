package javabase.equals;

/**
 * @Author whh
 */
public class TestMain {

    public static void main(String[] args) {

        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    }

}

//  基本数据类型   比较的是值              ==
//  非基本数据类型 比较的是内存地址         equals    比较的是值