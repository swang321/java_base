package 行为型模式.中介者模式.聊天软件;

/**
 * 抽象用户类
 *
 * @Author whh
 */
public class Colleague {

    /**
     * 维持一个抽象中介者的引用
     */
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 群发消息
     */
    public void sendmsg(String str) {
        System.out.println(this.getClass().getSimpleName().toString() + " sendmsg:\n" + str);
        mediator.operation(this, str);
    }

    /**
     * 两人对话
     */
    public void sendmsg(String key, String str) {
        System.out.println(this.getClass().getSimpleName().toString() + " sendmsg to " + key + ":\n" + str);
        mediator.operation(this, key, str);
    }

    /**
     * 接收消息
     */
    public void receivemsg(Colleague colleague, String str) {
        System.out.println(this.getClass().getSimpleName().toString() + " receivemsg:\n"
                + colleague.getClass().getSimpleName() + ":" + str);
    }
}
