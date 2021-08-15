package array;

/**
 * @author wangys
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
    //

    public static void main(String[] args) {
        Solution136 solu = new Solution136();
        System.out.println(solu.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solu.singleNumber(new int[]{2, 2 ,3, 4, 4}));
    }
}
