package javabase.throwable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @Author whh
 */
public class ExceptionTest {

    public static void main(String[] args) {

        String file = "C:\\anew_project\\text.txt1";
        FileReader reader;

        try {
            reader = new FileReader(file);

            Scanner in = new Scanner(reader);
            String out = in.next();
            System.out.println(out + "  不知道我有幸能够执行到不.....");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("对不起,你执行不到...");
        } finally {
            System.out.println("finally 在执行...");
        }

    }

}
