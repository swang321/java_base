package collection.equals;

/**
 * @Author admin
 */
public class Equals {

    public static void main(String[] args) {

        String s1 = "王哈哈";
        String s2 = "王哈哈";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = new String("王哈哈");
        String s4 = new String("王哈哈");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        // true     true   false   true
    }

    /**
     * 源码方法
     */
    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
