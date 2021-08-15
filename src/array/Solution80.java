package array;

import java.util.Arrays;

/**
 * @author wangyisu
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int index_now = 0;
        int i = 0;
        while(i<nums.length){
            int count = 1;
            while (i+1<nums.length && nums[i]==nums[i+1]){
                i++;
                count++;
            }
            nums[index_now] = nums[i];
            if(count==1){
                index_now++;
            }else{
                nums[index_now + 1] = nums[i];
                index_now+=2;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return index_now;
    }

    public static void main(String[] args) {
        Solution80 solu = new Solution80();
//        System.out.println(solu.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(solu.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
