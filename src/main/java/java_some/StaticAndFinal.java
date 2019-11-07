package java_some;

/**
 * @Author whh  2019/8/5 10:33
 */
public class StaticAndFinal {

    public final int whh;

    public StaticAndFinal(int whh) {
        this.whh = whh;
    }

    public static void main(String[] args) {
        String s;
    }

}
//public class java_some.StaticAndFinal {
//public static int whh;
//
//public java_some.StaticAndFinal();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: return
//
//static {};
//        Code:
//        0: ldc           #2                  // int 100000
//        2: putstatic     #3                  // Field whh:I
//        5: return
//        }