package 行为型模式.命令模式;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        CreateCommand createCommand = new CreateCommand(receiver);
        Invoker invoker = new Invoker(createCommand);
        invoker.call();

    }

}
