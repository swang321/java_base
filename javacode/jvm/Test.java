package jvm;

/**
 * @Author whh
 * @Time 2019/7/22 15:11
 */
public class Test {

    public static void main(String[] args) {


        String s1 = new String("aaa");
        String s2 = "aaa";
        //false
        System.out.println(s1 == s2);

        s1 = new String("bbb").intern();
        s2 = "bbb";
        //true
        System.out.println(s1 == s2);

        s1 = "ccc";
        s2 = "ccc";
        // true
        System.out.println(s1 == s2);

        s1 = new String("ddd").intern();
        s2 = new String("ddd").intern();
        // true
        System.out.println(s1 == s2);

        s1 = "ab" + "cd";
        s2 = "abcd";
        // true
        System.out.println(s1 == s2);

        String temp = "hh";
        s1 = "a" + temp;
        s2 = "ahh";
        // false
        System.out.println(s1 == s2);

        temp = "hh".intern();
        s1 = "a" + temp;
        s2 = "ahh";
        // false
        System.out.println(s1 == s2);

        temp = "hh".intern();
        s1 = ("a" + temp).intern();
        s2 = "ahh";
        // true
        System.out.println(s1 == s2);


    }
}

