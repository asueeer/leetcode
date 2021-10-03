package string;

import java.util.HashSet;
import java.util.Stack;

public class Solution345 {

    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                st.push(c);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                ans += st.pop();
            } else {
                ans += c;
            }
        }
        return ans;
    }
}
