package javabase.clone;

/**
 * @Author whh
 */
public class ClientMain2 {

    public static void main(String[] args) {

        Person.Email email = new Person.Email("请参加会议,请与今天12:30到二会议室参加会议...");

        Person person1 = new Person("张三", email);

        Person person2 = CloneUtils.clone(person1);
        person2.setName("李四");
        Person person3 = CloneUtils.clone(person1);
        person3.setName("王五");

        // 使张三提前半个小时到 其他人还是12点半到
        person1.getEmail().setText("请参加会议,请与今天12:00到二会议室参加会议...");

        System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getText());
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getText());
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getText());

    }

}
