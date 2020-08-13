package io.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author whh  2019/7/30 16:19
 */
public class Test {

    public static void main(String[] args) {

        List<User> list = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {

            User user = new User();
            user.setName("names");
            user.setAge(i);

            list.add(user);
        }

        Map<Integer, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(collect);

        Map<String, List<User>> collect1 = list.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(collect1);

    }

}
