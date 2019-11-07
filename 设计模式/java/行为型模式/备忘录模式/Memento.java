package 行为型模式.备忘录模式;

/**
 * 备忘录
 *
 * @Author whh
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
