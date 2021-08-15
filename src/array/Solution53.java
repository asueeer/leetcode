package array;

/**
 * @author wangyisu
 */
public class Solution53 {
    public static int result;
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum+=nums[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    public static int maxSubArray1(int[] nums) {
        if(allNegative(nums)){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i],max);
            }
            return max;
        }
        result = 0;
        findMaxSubArrary(nums, 0, 0);
        return result;
    }

    private static boolean allNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=0){
                return false;
            }
        }
        return true;
    }

    private static void findMaxSubArrary(int[] nums, int i, int sum) {
        if(sum>result){
            result=sum;
        }
        if(i==nums.length){
            return;
        }
        if(nums[i]>0){
            sum+=nums[i];
            findMaxSubArrary(nums, i+1, sum);
        }else{
            sum+=nums[i];
            findMaxSubArrary(nums, i+1, sum);
            sum=0;
            findMaxSubArrary(nums, i+1, sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
