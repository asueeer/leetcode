package list.node;

/**
 * @author wangyisu
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val>l2.val){
                    l3.next = new ListNode(l2.val);
                    l2 = l2.next;
                }else{
                    l3.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }else{
                if(l1==null){
                    l3.next = new ListNode(l2.val);
                    l2 = l2.next;
                }else{
                    l3.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }
            l3 = l3.next;
        }
        return head.next;
    }
}
