package list.node;

/**
 * @author wangyisu
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return head;
        }
        ListNode succ = head;
        ListNode pre = head;
        for (int i = 0; i < n+1; i++) {
            try{
                succ = succ.next;
            } catch (Exception e) {
                head = head.next;
                return head;
            }
        }
        while(succ!=null){
            pre = pre.next;
            succ = succ.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
