package array;

import static java.util.Arrays.sort;

/**
 * @author wangyisu
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]){
                return i;
            }
        }
        return -1;
    }

    public int search_(int[] nums, int target) {
        return BinarySearch(nums,target, 0, nums.length);
    }
    public int BinarySearch(int[] nums, int target, int lo, int hi){
        try{
            if(nums[lo]==target){
                return lo;
            }
            if(lo>=hi && nums[lo]!=target){
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }

        int mi = (lo+hi)/2;
        if(nums[mi]==target){
            return mi;
        }
        int result = BinarySearch(nums, target, lo, mi-1);
        if(result!=-1){
            return result;
        }else{
            return BinarySearch(nums, target, mi+1, hi);
        }
    }

    public static void main(String[] args) {
        Solution33 solu = new Solution33();
        System.out.println(solu.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
