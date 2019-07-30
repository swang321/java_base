package collection.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @Author whh
 * @Time 2019/7/19 10:47
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] list = {84, 25, 59, 71, 62};

        for (int i = 0; i < list.length; i++) {

            int minIndex = i;
            for (int j = i; j < list.length; j++) {
                if (list[minIndex] > list[j]) {
                    minIndex = j;
                }
            }
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
        System.out.println(Arrays.toString(list));
    }


}


//初始状态时，待排序序列为a1,a2,…an，已排序序列为空。
//第一趟排序，从待排序序列中找到最大或最小元素ak，将其与待排序序列的第一个元素a1对换，此时已排序序列为ak，长度为增加1，待排序序列长度减少1，变为n-1，其中ak被抽走了。
//第二趟排序，从待排序序列中找到最大或最小元素aj，将其与待排序序列的第一个元素a2对换，此时已排序序列为ak,aj，长度增加1，变为2，待排序序列长度减少1，变为n-2，其中aj又被抽走了。
//不断进行上面的排序操作，直到经过n-1趟排序后完成整个序列的排序。最终待排序序列为空，已排序序列长度为n。