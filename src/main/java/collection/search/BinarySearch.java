package collection.search;

/**
 * 二分 / 折半 查找  必须是线性结构  必须是有序的
 *
 * @author swang
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};
        int key = 92;

        int low = 0;
        int height = array.length - 1;
        int index = binarySearch(array, key, low, height);
        System.out.println(index);
    }

    private static int binarySearch(int[] array, int key, int low, int height) {
        if (low > height) {
            return -1;
        }
        int mid = (low + height) / 2;
        if (key == array[mid]) {
            return mid;
        } else if (key < array[mid]) {
            return binarySearch(array, key, low, height - 1);
        } else {
            return binarySearch(array, key, low + 1, height);
        }
    }

}
