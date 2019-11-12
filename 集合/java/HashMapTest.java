import java.util.HashMap;
import java.util.Map;

/**
 * @Author whh  2019/11/12 15:33
 */
public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        Map map = new HashMap(16);

        int i = tableSizeFor(16);
        System.out.println(i);

    }


    static final int tableSizeFor(int cap) {
        // 扩容门槛为传入的初始容量往上取最近的2的n次方
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
