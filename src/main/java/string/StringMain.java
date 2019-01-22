package string;

/**
 * @Date: 2019/1/22 10:37
 * @Description:
 * @Author admin
 */
public class StringMain {

    public static void main(String[] args) {

        String str = "ABCDEFG";

        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());

        char[] chars = str.toCharArray();
        System.out.println(chars.length);

    }


}
