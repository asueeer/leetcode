package array;

/**
 * @author wangyisu
 */
public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        int pre = 0;
        int succ = 0;
        while(pre<nums.length){
            while(succ<nums.length){
                if(nums[succ]!=nums[pre]){
                    nums[pre+1] = nums[succ];
                    break;
                }else{
                    succ++;
                }
            }
            if(succ==nums.length){
                break;
            }
            pre++;
        }
        return pre+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
