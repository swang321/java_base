package MyArrAyListTest;

/**
 * @Date: 2019/1/7 17:48
 * @Description:
 * @Author admin
 */
class MyException extends Throwable {

    private static final long serialVersionUID = -4128043099355507876L;

    MyException(String s, int index) {
        System.out.println(s + index);
    }


}
