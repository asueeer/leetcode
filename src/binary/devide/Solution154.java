package binary.devide;

/**
 * @author wangyisu
 */
public class Solution154 {

    public int findMin(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi && nums[hi]==nums[lo]){
            hi--;
        }

        if(nums[lo] <= nums[hi]){
            return nums[lo];
        }
        while (lo < hi){
            int mi = lo + (hi - lo)/2;
            if(nums[mi] >= nums[0]){
                hi = mi;
            }else{
                lo = mi + 1;
            }
        }
        return nums[hi];
    }
}
