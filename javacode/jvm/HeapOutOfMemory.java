package jvm;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * 堆溢出测试
 * args:-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
 *
 * @Author whh
 * @Time 2019/7/23 15:37
 */
public class HeapOutOfMemory {

    public static void main(String[] args) {

        ArrayList<Object> objects = Lists.newArrayList();
        int i = 0;
        while (true) {
            System.out.println(i++);
            objects.add(null);
        }
    }

}
