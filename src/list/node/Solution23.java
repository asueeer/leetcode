package list.node;

/**
 * @author wangyisu
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode record = head;
        while(lists!=null){
            int min_ = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]==null){
                    continue;
                }
                if(lists[i].val<min_){
                    index = i;
                    min_ = lists[i].val;
                }
            }
            if(index==-1){
                break;
            }
            head.next = new ListNode(min_);
            head = head.next;
            lists[index] = lists[index].next;
        }
        return record.next;
    }
}
