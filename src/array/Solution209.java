package array;

/**
 * @author wangyisu
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                len++;
                if(sum>=s){
                    System.out.println(sum);
                    result = Math.min(result, len);
                    break;
                }
            }
            sum = 0;
            len = 0;
        }
        if(result==Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution209 solu = new Solution209();
//        System.out.println(solu.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(solu.minSubArrayLen(3, new int[]{1, 1}));
    }
}
