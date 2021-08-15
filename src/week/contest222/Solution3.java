package week.contest222;

import java.util.HashMap;

public class Solution3 {
    private int[] sum;

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


    public int waysToSplit(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = sumRange(0, i);
            for (int j = nums.length - 2; j >= i + 1; j--) {
                int mid = sumRange(i + 1, j);
                int right = sumRange(j + 1, nums.length - 1);
                if (left <= mid && mid <= right) {
                    result++;
                }
                if (left > mid) {
                    break;
                }
            }
            if (left > sumRange(i + 1, nums.length - 1)) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.waysToSplit(new int[]{1, 1, 1}));
        System.out.println(solu.waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println(solu.waysToSplit(new int[]{3, 2, 1}));
    }
}
