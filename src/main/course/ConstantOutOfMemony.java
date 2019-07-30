import com.google.common.collect.Lists;

import java.util.List;

/**
 *  常量池内存溢出test
 *  -XX:PermSize=10M -XX:MaxPermSize=10M
 * @Author whh
 * @Time 2019/7/27 15:03
 */
public class ConstantOutOfMemony {


    public static void main(String[] args) {

        List<String> list = Lists.newArrayList();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }

    }


}
