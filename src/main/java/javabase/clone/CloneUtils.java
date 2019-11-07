package javabase.clone;

import java.io.*;

/**
 * @Author whh
 */
public class CloneUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // 写入字节流
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存 写入原始对象 生成心对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            cloneObj = (T) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }

}
