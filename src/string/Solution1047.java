package string;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1047 {

    public String removeDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st1.push(s.charAt(i));
        }
        st2.push(st1.pop());
        while (!st1.isEmpty()) {
            Character c = st1.pop();
            if (st2.isEmpty()) {
                st2.push(c);
                continue;
            }
            if (c == st2.peek()) {
                st2.pop();
                continue;
            }
            st2.push(c);
        }
        StringBuilder ret = new StringBuilder();
        while (!st2.isEmpty()) {
            ret.append(st2.pop());
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        // 输入："abbaca"
        // 输出："ca"
        Solution1047 solu = new Solution1047();
        System.out.println(solu.removeDuplicates("abbaca"));

        System.out.println(solu.removeDuplicates("aaaaaaaa"));
    }

}
