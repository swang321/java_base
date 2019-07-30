/**
 * @Author whh
 * @Time 2019/7/22 17:25
 */
class Singleton {
    public int count1;
    public int count2 = 0;
    private static Singleton singleton = new Singleton();

    public Singleton() {
        count1++;
        count2++;
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}