package collection.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author whh
 */
public class PeopleTest {

    public static void main(String[] args) {


        List<Map<String, String>> mapList = new ArrayList<>();

<<<<<<< HEAD
        Map<String, String> map = new HashMap<>(16);
        map.put("1", "1");

        Map<String, String> map1 = new HashMap<>(16);
        map1.put("2", "2");
=======
        Map<String,String> map=new HashMap<>(16);
        map.put("1","1");

        Map<String,String> map1=new HashMap<>(16);
        map1.put("2","2");
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979

        mapList.add(map);
        mapList.add(map1);

        Map<Map<String, String>, List<Map<String, String>>> mapListMap = mapList.stream().collect(Collectors.groupingBy((key) -> key));
        System.out.println(mapListMap);
    }


}
