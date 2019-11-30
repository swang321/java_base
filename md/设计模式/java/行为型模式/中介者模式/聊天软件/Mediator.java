package 行为型模式.中介者模式.聊天软件;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象聊天中心
 *
 * @Author whh
 */
public abstract class Mediator {


    /**
     * 用于存储同事对象
     */
    protected Map<String, Colleague> colleagueMap = new HashMap<>(16);

    /**
     * 注册方法，用于增加同事对象
     */
    public void register(String str, Colleague colleague) {
        colleagueMap.put(str, colleague);
    }

    /**
     * 声明抽象的业务方法：群发消息
     */
    public abstract void operation(Colleague colleague, String str);

    /**
     * 声明抽象的业务方法：两人对话
     */
    public abstract void operation(Colleague colleague, String key, String str);

}
