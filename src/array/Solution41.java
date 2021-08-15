package array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0){
            return 1;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int max_value = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            max_value = Math.max(nums[i], max_value);
        }
        if(max_value<0){
            return 1;
        }
        for (int i = 1; i < max_value; i++) {
            if(!hashSet.contains(i)){
                return i;
            }
        }
        return max_value+1;
    }
}
