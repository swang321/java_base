package javabase.clone;

/**
 * @Author whh
 */
public class ClientMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person.Email email = new Person.Email("请参加会议,请与今天12:30到二会议室参加会议...");

        Person person1 = new Person("张三", email);

        Person person2 = (Person) person1.clone();
        person2.setName("李四");
        Person person3 = (Person) person1.clone();
        person3.setName("王五");

        System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getText());
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getText());
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getText());

        test2();
    }


    private static void test2() throws CloneNotSupportedException {

        System.out.println();
        Person.Email email = new Person.Email("请参加会议,请与今天12:30到二会议室参加会议...");
        Person person1 = new Person("张三", email);
        Person person2 = (Person) person1.clone();
        person2.setName("李四");
        Person person3 = (Person) person1.clone();
        person3.setName("王五");

        // 使张三提前半个小时到 其他人还是12点半到
        person1.getEmail().setText("请参加会议,请与今天12:00到二会议室参加会议...");

        System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getText());
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getText());
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getText());
    }

}

// 浅拷贝 是引用 原来对象的地址
// 深拷贝 是新创建的对象 所有的属性实例等 都和源对象一样，两个对象互不影响


//1、 基本类型：如果变量是基本很类型，则拷贝其值，比如int、float等。
//2、 对象：如果变量是一个实例对象，则拷贝其地址引用，也就是说此时新对象与原来对象是公用该实例变量。
//3、 String字符串：若变量为String字符串，则拷贝其地址引用。但是在修改时，它会从字符串池中重新生成一个新的字符串，原有String对象保持不变。

//基本数据类型是值传递，所以修改值后不会影响另一个对象的该属性值；
//
//引用数据类型是地址传递（引用传递），所以修改值后另一个对象的该属性值会同步被修改。