package collection.map;

/**
 * @Author whh
 */
public interface MyMap {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Object get(Object key);

    Object put(Object key, Object value);

    Object remove(Object key);


    interface Entry<K, V> {

        K getKey();

        V getValue();
    }


}
