package 行为型模式.责任链模式;

/**
 * 具体处理者角色
 *
 * @Author whh
 */
public class CreateHandle extends Handle {


    @Override
    public void handleRequest(String param) {
        boolean isTrue = param == null;

        //如果满足条件，处理；如果不满足，则转发请求请求
        if (isTrue) {
            System.out.println(this.getClass().getSimpleName() + "hand1 处理请求");
        } else {
            //如果有下个处理者
            if (getHandle() != null) {
                //转发请求
                System.out.println(this.getClass().getSimpleName() + "转达请求");
                this.handle.handleRequest(param);
            } else {
                System.out.println(this.getClass().getSimpleName() + "无人处理");
            }
        }
    }
}
