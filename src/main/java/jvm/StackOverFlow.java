package jvm;

/**
 * java 栈溢出
 * VM args: -verbose:gc -Xss128k -XX:+PrintGCDetails
 *
 * @Author whh
 * @Time 2019/7/27 14:55
 */
public class StackOverFlow {

    private int i;

    public void plus() {
        i++;
        plus();
    }

    public static void main(String[] args) {

        StackOverFlow stackOverFlow = new StackOverFlow();

        try {
            stackOverFlow.plus();
        } catch (Exception e) {
            System.out.println("Exception stack length: " + stackOverFlow.i);
        } catch (Error error) {
            System.out.println("Error stack length: " + stackOverFlow.i);
            error.printStackTrace();
        }


    }

}
