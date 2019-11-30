package 行为型模式.命令模式;

/**
 * 具体命令类
 *
 * @Author whh
 */
public class CreateCommand extends Command {

    private Receiver receiver;

    public CreateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //调用请求接收者的业务处理 action
        receiver.action();
    }
}
