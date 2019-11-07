package 行为型模式.责任链模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {


        Handle handle = new CreateHandle();
        Handle handle1 = new CreateHandle2();

        handle.setHandle(handle1);
        handle.handleRequest(null);
        System.out.println("-------------");
        handle.handleRequest("11");

    }

}
//    使用场景
//
//            Servlet中的过滤器Filter