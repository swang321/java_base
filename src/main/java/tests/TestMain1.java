package tests;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author whh
 */
public class TestMain1 {

    private static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>(16);

    public static void main(String[] args) {

        initData();

        HashMap<Integer, Integer> mapLevelThird = null;
        if (map != null) {
            mapLevelThird = map.get(1);
        }
        int i = 0;
        if (mapLevelThird != null && mapLevelThird.get(3) != null) {
            i = mapLevelThird.get(3);
        }

        System.out.println(i);

    }

    private static void initData() {
        HashMap<Integer, Integer> temp = new HashMap<>(16);
        temp.put(1, 1);
        temp.put(2, 2);
        map.put(1, temp);
    }

}
