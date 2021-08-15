package array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution379 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]-1)){
                System.out.println(nums[i] + " 跳过");
                continue;
            }else{
                int start = nums[i];
                System.out.println("start," + start);
                int longestConsecutive_fromStart = 1;
                while (set.contains(start+1)){
                    longestConsecutive_fromStart++;
                    start++;
                }
                result = Math.max(result, longestConsecutive_fromStart);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution379 solu = new Solution379();
        System.out.println(solu.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));


        int[] a = new int[5];
        for (int i : a) {

        }
    }
}
