package list.node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangyisu
 */
public class LFUCache {
    DoublyListNode<EntryKV<Integer /* 次数 */, LinkedHashMap<Integer,Integer>> /* 缓存里的key和value */> dummy_head;
    DoublyListNode<EntryKV<Integer /* 次数 */, LinkedHashMap<Integer,Integer>> /* 缓存里的key和value */> dummy_tail;
    HashMap<Integer /* key */, DoublyListNode<EntryKV<Integer,LinkedHashMap<Integer,Integer>>> /* 节点 */> hashMap;
    HashMap<Integer /* frequency */, DoublyListNode<EntryKV<Integer,LinkedHashMap<Integer,Integer>>> /* 节点 */> hashMapStoredFrequency;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        dummy_head = new DoublyListNode<>(null);
        dummy_tail = new DoublyListNode<>(null);
        dummy_head.next = dummy_tail;
        dummy_tail.pre = dummy_head;
        hashMapStoredFrequency = new HashMap<>();
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if(!hashMap.containsKey(key)){
            return -1;
        }
        DoublyListNode<EntryKV<Integer, LinkedHashMap<Integer,Integer>>> node = hashMap.get(key);
        LinkedHashMap<Integer,Integer> nodes = node.val.value;
        int frequency = node.val.key;
        int value = nodes.get(key);
        if(!hashMapStoredFrequency.containsKey(frequency+1)){
            LinkedHashMap<Integer,Integer> nextNodes = new LinkedHashMap<>();
            EntryKV<Integer, LinkedHashMap<Integer,Integer>> entryKV = new EntryKV<>(frequency+1, nextNodes);
            DoublyListNode<EntryKV<Integer, LinkedHashMap<Integer,Integer>>> nextNode = new DoublyListNode<>(entryKV);
            // nextNode 放到node后面
            nextNode.next = node.next;
            nextNode.next.pre = nextNode;
            node.next = nextNode;
            nextNode.pre = node;
            nextNodes.put(key,value);
            hashMapStoredFrequency.put(frequency+1,nextNode);
            hashMap.put(key,nextNode);
        }else{
            LinkedHashMap<Integer,Integer> nextNodes = hashMapStoredFrequency.get(frequency+1).val.value;
            nextNodes.put(key,value);
            hashMap.put(key,hashMapStoredFrequency.get(frequency+1));
        }
        nodes.remove(key);
        if(nodes.size()==0){
            int removedFrequency = frequency;
            hashMapStoredFrequency.remove(removedFrequency);
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return value;
    }

    public void put(int key, int value) {
        if(capacity<=0){
            return;
        }
        if(hashMap.containsKey(key)){
            hashMap.get(key).val.value.put(key,value);
            get(key);
            return;
        }
        if(hashMap.size()==capacity){
            LinkedHashMap<Integer,Integer> leastUsedNodes = dummy_head.next.val.value;
            int removedKey = getHead(leastUsedNodes).getKey();
            leastUsedNodes.remove(removedKey);
            if(leastUsedNodes.size()==0){
                int removedFrequency = dummy_head.next.val.key;
                hashMapStoredFrequency.remove(removedFrequency);
                dummy_head.next = dummy_head.next.next;
                dummy_head.next.pre = dummy_head;
            }
            hashMap.remove(removedKey);
        }
        if(!hashMapStoredFrequency.containsKey(1)){
            LinkedHashMap<Integer,Integer> nodes = new LinkedHashMap<>();
            EntryKV<Integer, LinkedHashMap<Integer,Integer>> entryKV = new EntryKV<>(1, nodes);
            DoublyListNode<EntryKV<Integer, LinkedHashMap<Integer,Integer>>> node = new DoublyListNode<>(entryKV);
            // node 放到dummy_head后面
            node.next = dummy_head.next;
            node.next.pre = node;
            dummy_head.next = node;
            node.pre = dummy_head;
            nodes.put(key,value);
            hashMap.put(key,node);
            hashMapStoredFrequency.put(1,node);
        }else{
            LinkedHashMap<Integer,Integer> nodes = hashMapStoredFrequency.get(1).val.value;
            nodes.put(key,value);
            hashMap.put(key, hashMapStoredFrequency.get(1));
        }
    }

    public <K, V> Map.Entry<K, V> getHead(LinkedHashMap<K, V> map) {
        return map.entrySet().iterator().next();
    }

    public static void main(String[] args) {
//        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));// 返回 1
//        cache.put(3, 3);    // 去除 key 2
//        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
//        System.out.println(cache.get(3));       // 返回 3
//        cache.put(4, 4);    // 去除 key 1
//        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
//        System.out.println(cache.get(3));       // 返回 3
//        System.out.println(cache.get(4));       // 返回 4
        LFUCache cache = new LFUCache( 0 /* capacity (缓存容量) */ );
        cache.put(0,0);
        System.out.println(cache.get(0));
    }
}
