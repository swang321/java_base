package collection.test;

import java.util.*;

/**
 * @Date: 2019/1/10 11:47
 * @Description:
 * @Author admin
 */
public class Test {

    public static void main(String[] args) {


        User user = new User("1", "1");
        User user1 = new User("1", "1");

        Collection<User> collection1 = new ArrayList<User>();
        collection1.add(user);
        collection1.add(user1);
        System.out.println(collection1.contains(user1));

        List list = new ArrayList();
        list.add(0, 5);
        System.out.println(list);

        Map map=new HashMap(16);

        Set set = new TreeSet();
        Set sets = new HashSet();


    }

    static class User {
        String name;
        String pwd;

        public User() {
        }

        User(String name, String pwd) {
            this.name = name;
            this.pwd = pwd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }

}
