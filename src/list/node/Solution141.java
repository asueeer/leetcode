package list.node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> nodes = new HashMap<>();
        while(head!=null){
            if(nodes.containsKey(head)){
                return true;
            }
            nodes.put(head, 0);
            head = head.next;
        }
        return false;
    }
}
