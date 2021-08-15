package string;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author wangyisu
 */
public class Solution32 {
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution32() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }


    public int longestValidParentheses_(String s) {
        int result = 0;
        int len = 0;
        if(s.length()%2==0){
            len = s.length();
        }else{
            len = s.length()-1;
        }
        for (int i = len; i >=0; i-=2) {
            for (int j = 0; j < s.length()-i; j++) {
                if(isValid(s.substring(j,j+i))){
                    return i;
                }
            }
        }
        return result;
    }
}
