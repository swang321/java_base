package 行为型模式.中介者模式.聊天软件;

/**
 * 具体聊天中心
 *
 * @Author whh
 */
public class ConcreteMediator extends Mediator {

    /**
     * 实现业务方法，群发消息
     */
    @Override
    public void operation(Colleague colleague, String str) {

        colleagueMap.forEach((key, value) -> {
            if (value != colleague) {
                value.receivemsg(colleague, str);
            }
        });
    }

    /**
     * 实现业务方法，两人对话
     */
    @Override
    public void operation(Colleague colleague, String key, String str) {
        colleagueMap.get(key).receivemsg(colleague, str);
    }
}
