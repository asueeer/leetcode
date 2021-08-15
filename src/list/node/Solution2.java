package list.node;

/**
 * @author wangyisu
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1!=null || l2!=null){
            if(l3.val + l1.val+l2.val<10){
                l3.val = l3.val + l1.val+l2.val;
                l3.next = new ListNode(0);
            }else{
                l3.val = l3.val + l1.val+l2.val - 10;
                l3.next = new ListNode(1);
            }
            if(l1.next==null && l2.next!=null){
                l1.next = new ListNode(0);
            }
            if(l1.next!=null && l2.next==null){
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            if(l1==null && l2==null && l3.next.val!=0){
                l3.next = null;
            }else{
                l3 = l3.next;
            }
        }
        return head;
    }
}
