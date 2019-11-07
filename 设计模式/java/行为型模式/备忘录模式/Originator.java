package 行为型模式.备忘录模式;

/**
 * 原发器
 *
 * @Author whh
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void rectorMemento(Memento memento) {
        this.setState(memento.getState());
    }

}
