package array;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wangyisu
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                product*=nums[j];
                result = Math.max(product, result);
            }
            result = Math.max(product, result);
        }
        return result;
    }
}
