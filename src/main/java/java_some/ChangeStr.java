package java_some;

import java.lang.reflect.Field;

/**
 * @Author whh  2019/8/6 17:43
 */
public class ChangeStr {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        String str = "hello_word";
        System.out.println(str);

        //获取String类中的value字段
        Field value = String.class.getDeclaredField("value");

        //改变value属性的访问权限
        value.setAccessible(true);

        //获取s对象上的value属性的值
        char[] o = (char[]) value.get(str);

        //改变value所引用的数组中的第5个字符
        o[5] = '%';
        System.out.println(o);
    }

}
