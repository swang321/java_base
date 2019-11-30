package 行为型模式.访问者模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author whh
 */
public class ObjectStruture {

    /**
     * 定义一个集合用于存储元素对象
     */
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((Element) iterator.next()).accept(visitor);
        }

    }

    public void addElement(Element element) {
        list.add(element);
    }

    public void removeElement(Element element) {
        list.remove(element);
    }

}
