package lamabda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author whh
 */
public class LambdaMain {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " go");
            }
        }).start();


        // Lambda表达式标准写法
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " go");
        }).start();

        // Lambda 省略写法
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " go")).start();

        User[] users = {new User("哈哈", 25), new User("谷谷", 18), new User("苍苍", 20)};

//        Arrays.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

//        System.out.println(Arrays.toString(users));
        //  输出
        //  [User{name='谷谷', age=18}, User{name='苍苍', age=20}, User{name='哈哈', age=25}]

//        Arrays.sort(users, (User u1, User u2) -> {
//            return u1.getAge() - u2.getAge();
//        });

        Arrays.sort(users, Comparator.comparingInt(User::getAge));

        System.out.println(Arrays.toString(users));
    }

}
