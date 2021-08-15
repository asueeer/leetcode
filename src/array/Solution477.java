package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        ArrayList<ArrayList<Integer>> combines = anyTwoNumbers(nums);
        int result = 0;
        for (int i = 0; i < combines.size(); i++) {
            result+=hammingDistance(combines.get(i).get(0),combines.get(i).get(1));
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> anyTwoNumbers(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int bigNum = Math.max(nums[i],nums[j]);
                int smallNum = Math.min(nums[i],nums[j]);
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(bigNum);
                lst.add(smallNum);
                result.add(lst);
            }
        }
        return result;
    }

    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x^y);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}
