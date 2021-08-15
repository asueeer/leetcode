package dp.house.robber;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution213 {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    int max_ = 0;

    public int rob(int[] nums) {
        // 处理边界：nums=[]或者nums=[1]
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        robByStep(nums,1,0);
        nums[nums.length-1] = 0;
        robByStep(nums, 0, 0);
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
        Solution213 solution213 = new Solution213();
        System.out.println(solution213.rob(new int[]{2,3,2}));
        System.out.println(solution213.rob(new int[]{1,2,3,1}));
    }
}
