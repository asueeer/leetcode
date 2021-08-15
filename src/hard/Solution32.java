package hard;

import java.util.Stack;

/**
 * @author wangyisu
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) { // 被匹配为1，未被匹配为0

            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    // 未被匹配的右括号标记为0
                    arr[i] = 0;
                }else{
                    arr[stack.pop()] = 1;
                    arr[i] = 1;
                }
            }
        }

        // 未被匹配的左括号标记为0
        while (!stack.isEmpty()){
            arr[stack.pop()] = 0;
        }

        return NumOfContinuousOnes(arr);
    }

    private int NumOfContinuousOnes(int[] arr) { // 最长的连续为1的序列长度
        int result = 0;
        int i = 0;
        while (i < arr.length){
            if(arr[i]==1){
                int len = 0;
                for (int j = i; j < arr.length; j++) {
                    if(arr[j]==1){
                        len++;
                    }else{
                        i = j;
                        break;
                    }
                }
                result = Math.max(len, result);
            }
            i++;
        }
        return result;
    }
}
