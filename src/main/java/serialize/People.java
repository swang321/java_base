package serialize;

import java.io.Serializable;

/**
 * @Date: 2019/1/18 10:35
 * @Description:
 * @Author admin
 */
public class People implements Serializable {

    private static final long serialVersionUID = -6717370953377814305L;
    private String name;
    private String adress;

    public People() {
    }

    public People(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
