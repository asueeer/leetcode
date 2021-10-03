package week.be_week_62;

import java.util.HashSet;

public class Solution2 {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0;

        HashSet<String> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target.equals(nums[i] + nums[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.numOfPairs(new String[]{"777", "7", "77", "77"}, "7777")); // 4
    }
}
