package java_some;

import java.util.HashMap;

/**
 * @Author whh  2019/8/5 11:25
 */
public class Str {

    public static void main(String[] args) {

        String a = "hello";
        a = a + "2";

        HashMap map = new HashMap();


    }

}

//public class java_some.Str {
//public java_some.Str();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: ldc           #2                  // String hello
//        2: astore_1
//        3: new           #3                  // class java/lang/StringBuilder
//        6: dup
//        7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
//        10: aload_1
//        11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        14: ldc           #6                  // String 2
//        16: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        19: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
//        22: astore_1
//        23: return
//        }
