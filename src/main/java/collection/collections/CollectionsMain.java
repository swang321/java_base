package collection.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author whh
 */
public class CollectionsMain {

    public static void main(String[] args) {

        List list = Arrays.asList(6, 8, 3, 5, 4, 2, 9, 1, 7);

        //排序
        Collections.sort(list);
        System.out.println(list);

        // 从集合中取出 9  得索引  （前提是必须是已经排好序得列表）
        int index = Collections.binarySearch(list, 9);
        System.out.println(index);

        // 反序
        Collections.reverse(list);
        System.out.println(list);

        //  两个索引处得数据交换位置
        Collections.swap(list, 0, 8);
        System.out.println(list);

        // 重新洗牌 打乱顺序
        Collections.shuffle(list);
        System.out.println(list);

        // 把list  集合 整体向右移动两位
        Collections.rotate(list, 2);
        System.out.println(list);

        // 最大值  最小值
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        //  把集合所有得元素都换成 666
        Collections.fill(list, 666);
        System.out.println(list);

        List list2 = Arrays.asList(6, 8, 3, 5, 4, 2, 9, 1, 7);
        Collections.replaceAll(list2, 6, 12);
        System.out.println(list2);


    }

}
