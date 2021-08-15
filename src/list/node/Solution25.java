package list.node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangyisu
 */
public class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 用多个栈保存k个一组的链表节点
        List<Stack<ListNode>> stacks = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.add(head);
            head = head.next;
            if(stack.size()==k){
                stacks.add((Stack<ListNode>) stack.clone());
                stack = new Stack<>();
            }
        }
        // 如果最后一组的链表组不为k，保留它的原有顺序
        if(stack.size()!=0){
            Stack<ListNode> temp = new Stack<>();
            while(!stack.empty()){
                temp.add(stack.pop());
            }
            stacks.add((Stack<ListNode>) temp.clone());
        }
        // 将链表组逐个相连
        ListNode dummy = new ListNode(0);
        dummy.next = stacks.get(0).peek();
        for (int i = 0; i < stacks.size(); i++) {
            Stack<ListNode> st = stacks.get(i);
            while(!st.empty()){
                head = st.pop();
                if(!st.empty()){
                    head.next = st.peek();
                }else{
                    try{
                        head.next = stacks.get(i+1).peek();
                    } catch (Exception e) {
                        head.next = null;
                    }
                }
            }
        }
        return dummy.next;
    }
}
