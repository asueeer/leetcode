package list.node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ArrayList<Integer> lst_lessThanX = new ArrayList<>();
        ArrayList<Integer> lst_noLessThanX = new ArrayList<>();
        ArrayList<Integer> lst = new ArrayList<>();
        while(head!=null){
            if (head.val<x){
                lst_lessThanX.add(head.val);
            } else{
                lst_noLessThanX.add(head.val);
            }
            head = head.next;
        }
        for (int i = 0; i < lst_lessThanX.size(); i++) {
            lst.add(lst_lessThanX.get(i));
        }
        for (int i = 0; i < lst_noLessThanX.size(); i++) {
            lst.add(lst_noLessThanX.get(i));
        }

        head = new ListNode(lst.get(0));
        ListNode result = head;
        for (int i = 1; i < lst.size(); i++) {
            head.next = new ListNode(lst.get(i));
            head = head.next;
        }
        return result;
    }
}
