package list.node;

import java.util.Stack;

/**
 * @author wangyisu
 */
public class ListNode extends Stack<ListNode> {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
