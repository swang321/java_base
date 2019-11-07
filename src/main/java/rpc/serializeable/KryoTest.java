package rpc.serializeable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author whh
 * @Time 2019/7/17 15:19
 */
public class KryoTest {

    public static void main(String[] args) throws FileNotFoundException {

        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("student.db"));
        Student kirito = new Student("kirito");
<<<<<<< HEAD
        kryo.writeObject(output, kirito);
=======
        kryo.writeObject(output,kirito);
>>>>>>> 61b50b7609c7b8eb97f29dbc145658e6bc2cb979
        output.close();

    }
}


class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}