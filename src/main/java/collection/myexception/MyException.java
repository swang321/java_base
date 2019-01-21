package collection.myexception;

/**
 * @Author admin
 */
public class MyException extends Throwable {

    public static final long serialVersionUID = -4128043099355507876L;

    public MyException(String s, int index) {
        System.out.println(s + index);
    }


}
