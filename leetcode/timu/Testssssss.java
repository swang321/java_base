/**
 * @Author whh  2019/12/24 15:46
 */
public class Testssssss {

    public static void main(String[] args) {
        Userssss userssss = new Userssss(18, "ads");
        String s = XMLConverUtil.convertToXML(userssss);
        System.out.println(s);

    }

}

class Userssss {

    private Integer age;

    private String name;

    public Userssss(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}