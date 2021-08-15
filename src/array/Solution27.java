package array;

import static java.util.Arrays.sort;

/**
 * @author wangyisu
 */
public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        sort(nums);
        int pre = 0;
        int succ = 0;
        while(pre!=nums.length){
            if(nums[pre]!=val){
                pre++;
            }else{
                break;
            }
        }
        succ = pre+1;
        while(succ<nums.length){
            if(nums[succ]!=val){
                break;
            }else{
                succ++;
            }
        }
        while(succ<nums.length){
            nums[pre] = nums[succ];
            succ++;
            pre++;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int n = removeElement(nums,2);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
        nums = new int[]{};
        System.out.println(removeElement(nums,0));
    }
}
