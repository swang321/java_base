package javabase.serialize;

import java.io.*;

/**
 * @Date: 2019/1/18 10:35
 * @Description:
 * @Author admin
 */
public class SerializeDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"));
        sb.append("\\javabase.serialize.ser");

        serializePeople(String.valueOf(sb));
        reverseSerializePeople(String.valueOf(sb));
    }

    /**
     * 反序列化  people
     */
    private static void reverseSerializePeople(String filePath) {
        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream input = new ObjectInputStream(fileInputStream);
            People people = (People) input.readObject();
            input.close();
            fileInputStream.close();
            System.out.println(people.getAdress());
            System.out.println(people.getName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化 people
     */

    private static void serializePeople(String filePath) {
        People people = new People();
        people.setName("whh");
        people.setAdress("深圳");
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(people);
            out.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in " + filePath);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
