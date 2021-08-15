package list.node;

import java.util.Map;

/**
 * @author wangyisu
 */
public class EntryKV<K,V>{
    K key;
    V value;

    public EntryKV(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        EntryKV<Integer,Integer> entryKV = new EntryKV<>(0,0);
        System.out.println(entryKV.key);
    }
}
