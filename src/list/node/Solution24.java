package list.node;

/**
 * @author wangyisu
 */
public class Solution24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head!=null){
            try{
                ListNode nex = head.next;
                pre.next = nex;
                head.next = nex.next;
                nex.next = head;
                pre = head;
                head = head.next;
            } catch (Exception e) {
                pre.next = head;
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        swapPairs(temp);
    }
}
