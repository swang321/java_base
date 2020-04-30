import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author whh  2020/4/30 15:38
 */
public class Test {

    public static void main(String[] args) {

        HashMap<Integer, User> map = new HashMap<>();

        map.put(1, new User(1));
        map.put(3, new User(3));
        map.put(2, new User(2));


        Set<Map.Entry<Integer, User>> entries = map.entrySet();

        List<Map.Entry<Integer, User>> collect = entries.stream().sorted(Comparator.comparing(a -> a.getValue().age)).collect(Collectors.toList());

        collect.forEach(k -> {
            System.out.println(k);
        });

    }

    private static class User {
        private Integer age;

        public User(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    '}';
        }
    }
}
