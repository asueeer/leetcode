package stack;

import java.util.Stack;

public class Solution71 {

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] ss = path.split("/");
        for (String s : ss) {
            if (s.equals("/") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }
            if (s.length() == 0) {
                continue;
            }
            st.push(s);
        }
        Stack<String> tmp = new Stack<>();
        while (!st.isEmpty()) {
            tmp.push(st.pop());
        }
        System.out.println(tmp);
        String res = "/";
        while (!tmp.isEmpty()) {
            if (tmp.size() == 1) {
                res += tmp.pop();
                continue;
            }
            res += tmp.pop() + "/";
        }
        return res;
    }

    public static void main(String[] args) {
        Solution71 solu = new Solution71();
        System.out.println(solu.simplifyPath("/home/")); // "/home"
    }
}
