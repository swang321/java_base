package collection.search;

import java.util.Arrays;

/**
 * @Date: 2019/1/10 10:38
 * @Description: 冒泡排序
 * @Author admin
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {8, 7, 9, 2, 3, 5, 6, 1};
        int[] arrayTest = {86, 57, 39, 12, 23, 45, 66, 91};
        System.out.println(Arrays.toString(arraySort(array)));
        System.out.println(Arrays.toString(arraySort(arrayTest)));

    }

    /**
     * 相邻的两位数做比较，1和2比较 2和3比较 3和4比较，这样依次比较，如果前面的数小于后面的，不做操作，
     * 如果前面的数大于后面的数则调换两个数字的位置，列1>2 则数字顺序为2 1(注：此时的1 2 3 4 5代表索引而不是数组)，
     * 所以一层循环能挑出一个当前数组参与比较数字中的最大的数字，并将其排到数组的最末尾。
     */
    private static int[] arraySort(int[] array) {
        int temp;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }

            }

        }
        return array;
    }
}
