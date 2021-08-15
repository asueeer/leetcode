package list.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyisu
 */
public class LRUCache {
    public class DoublyListNode {
        EntryKV val;
        DoublyListNode next;
        DoublyListNode pre;
        DoublyListNode(EntryKV x) {
            val = x;
        }
    }
    public class EntryKV{
        public int key;
        public int value;

        public EntryKV(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public EntryKV(EntryKV entryKV) {
            this.key = entryKV.key;
            this.value = entryKV.value;
        }
    }

    // 一开始是用范型写的，结果报错
    HashMap<Integer, DoublyListNode> hashMap;
    DoublyListNode dummyHead;
    DoublyListNode dummyTail;
    int capacity;
    public LRUCache(int capacity) {
        hashMap = new HashMap<>();
        dummyHead = new DoublyListNode(new EntryKV(0,0));
        dummyTail = new DoublyListNode(new EntryKV(0,0));
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            DoublyListNode doublyListNode = hashMap.get(key);
            // 断开
            doublyListNode.pre.next = doublyListNode.next;
            doublyListNode.next.pre = doublyListNode.pre;
            // 该节点放到头部
            doublyListNode.next = dummyHead.next;
            dummyHead.next = doublyListNode;
            doublyListNode.next.pre = doublyListNode;
            doublyListNode.pre = dummyHead;
            return doublyListNode.val.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            DoublyListNode doublyListNode = hashMap.get(key);
            doublyListNode.val.value = value;
            get(key);
            return;
        }

        if(hashMap.size()==capacity){
            // 删除尾部节点
            System.out.println(true);
            int removedKey = dummyTail.pre.val.key;
            System.out.println("removedkey"+removedKey);
            dummyTail.pre = dummyTail.pre.pre;
            dummyTail.pre.next = dummyTail;
            hashMap.remove(removedKey);
        }
        DoublyListNode doublyListNode = new DoublyListNode(new EntryKV(key,value));
        doublyListNode.next = dummyHead.next;
        doublyListNode.next.pre = doublyListNode;
        dummyHead.next = doublyListNode;
        doublyListNode.pre = dummyHead;
        hashMap.put(key,doublyListNode);
    }

    public static void main(String[] args) {
        LRUCache cache;
        cache = new LRUCache( 1 /* capacity (缓存容量) */ );
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
