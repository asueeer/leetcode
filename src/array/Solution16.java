package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static java.util.Collections.sort;

/**
 * @author wangyisu
 */
public class Solution16 {
    public static int threeSumClosest(int[] nums, int target) {
        int result = 9999999;
        HashSet<Integer> computed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!computed.contains(nums[i])) {
                if(Math.abs(result-target)>Math.abs(target-twoSum(nums,i,target))){
                    result = twoSum(nums,i,target);
                }
            }
        }
        return result;
    }

    // 找到nums中相加为-num[i]的两个值
    private static int twoSum(int[] nums, int i, int target) {
        int result = 9999999;
        for (int j = 0; j < nums.length; j++) {
            if(j!=i){
                for (int k = 0; k < nums.length; k++) {
                    if(k!=j && k!=i){
                        if(Math.abs(result-target)>Math.abs(target-nums[i]-nums[j]-nums[k])){
                            result = nums[i]+nums[j]+nums[k];
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
        System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3},-1));
    }
}
