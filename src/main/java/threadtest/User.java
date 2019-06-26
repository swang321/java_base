package threadtest;

import java.io.Serializable;

/**
 * @Author whh
 */
public class User implements Serializable {

    private static final long serialVersionUID = 4297137712254653853L;
    private int id;
    private int name;

    public User() {
    }

    public User(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
