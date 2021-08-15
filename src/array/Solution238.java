package array;

/**
 * @author wangyisu
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] productsLeft = new int[nums.length];
        int[] productsRight = new int[nums.length];
        int[] result = new int[nums.length];
        productsLeft[0] = 1;
        productsRight[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            productsLeft[i] = productsLeft[i-1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >-1 ; i--) {
            productsRight[i] = productsRight[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = productsLeft[i]*productsRight[i];
        }
        return result;
    }
}
