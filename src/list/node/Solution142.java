package list.node;


import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> nodes = new HashMap<>();
        while(head!=null){
            if(nodes.containsKey(head)){
                return head;
            }
            nodes.put(head, 0);
            head = head.next;
        }
        return null;
    }
}
