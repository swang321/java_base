package 关键子;

/**
 * @Author whh  2019/11/7 14:06
 */
public class SynchronizedTest {

    public synchronized void test1(){

    }

    public void test2(){
        synchronized (this){

        }
    }

}
