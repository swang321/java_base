import com.google.common.base.Objects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author whh  2019/11/12 15:33
 */
public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        Set<Object> objects = new HashSet<>();

        Map<StuMap, Integer> map = new HashMap<>(16);
        StuMap stuMap;
        for (int i = 0; i < 30; i++) {
            stuMap = new StuMap();
            stuMap.setAge(i);
            map.put(stuMap, i);
        }
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

class StuMap {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        if (age >= 12) {
            return 1;
        }
        return Objects.hashCode(age);
    }
}
