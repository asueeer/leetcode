package dp.house.robber;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution198 {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    int max_ = 0;

    public int rob(int[] nums) {
        robByStep(nums, 0, 0);
        // 清理，以便后续使用
        int temp = max_;
        max_ = 0;
        hashMap.clear();
        return temp;
    }

    private void robByStep(int[] nums, int start, int money) {
        if(!hashMap.containsKey(start) || hashMap.get(start)<money){
            hashMap.put(start,money);
        }
        if(hashMap.get(start)>money){
            return;
        }
        if(start>=nums.length){
            if(max_<money){
                max_ = money;
            }
            return;
        }
        // 如果没什么好抢的就直接去下一个房子，这是为了防止{0,0,0,0,0,0,0}的情况
        if(nums[start]==0){
            robByStep(nums, start+1, money+nums[start]);
            return;
        }
        // 抢当前所在的房子
        robByStep(nums, start+2, money+nums[start]);
        // 不抢当前所在的房子
        robByStep(nums, start+1, money);
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        int[] nums = {1,2,3,1};
        System.out.println(solution198.rob(nums));
        System.out.println(solution198.rob(new int[]{2,7,9,3,1}));
        System.out.println(solution198.rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }
}
