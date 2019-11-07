package 行为型模式.中介者模式.聊天软件;

/**
 * @Author whh
 */
public class Client {

    public static void main(String[] args) {

        ConcreteMediator cm = new ConcreteMediator();
        ConcreteColleagueA acm = new ConcreteColleagueA(cm);
        ConcreteColleagueB bcm = new ConcreteColleagueB(cm);
        ConcreteColleagueC ccm = new ConcreteColleagueC(cm);
        cm.register("acm", acm);
        cm.register("bcm", bcm);
        cm.register("acm", ccm);

        acm.sendmsg("hello  aaaa");
        System.out.println("-----------");
        acm.sendmsg("bcm", "what are you");


    }

}
