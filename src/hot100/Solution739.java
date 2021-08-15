package hot100;

import java.util.*;

public class Solution739 {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int begin = stack.pop();
                result[begin] = i - begin;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int begin = stack.pop();
            result[begin] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solu = new Solution739();
        System.out.println(Arrays.toString(solu.dailyTemperatures(T)));
    }
}
