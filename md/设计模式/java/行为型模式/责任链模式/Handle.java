package 行为型模式.责任链模式;

/**
 * 抽象处理者角色
 *
 * @Author whh
 */
public abstract class Handle {

    /**
     * 持有后继的责任对象
     */
    protected Handle handle;

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    /**
     * 根据具体需要来选择是否传递参数
     */
    public abstract void handleRequest(String param);
}
