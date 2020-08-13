package javabase.fengzhuang;

/**
 * @Author whh
 */
public class Husband {

    /**
     * 对象   属性 姓名 性别 年龄 妻子 私人属性的封装
     */
    private String name;
    private int age;
    private Wife wife;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
