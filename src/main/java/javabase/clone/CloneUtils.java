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
<<<<<<< HEAD
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            cloneObj = (T) ois.readObject();
=======
            ByteArrayInputStream ios=new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(ios);
            cloneObj =(T) ois.readObject();
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }

}
