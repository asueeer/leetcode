package doubly.pointer;

import java.util.LinkedList;

/**
 * @author wangyisu
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        LinkedList<Integer> lst_non_zeros = new LinkedList<>();
        LinkedList<Integer> lst_zeros = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                lst_zeros.add(nums[i]);
            }else{
                lst_non_zeros.add(nums[i]);
            }
        }
        for (int i = 0; i < lst_zeros.size(); i++) {
            lst_non_zeros.add(0);
        }
        for (int i = 0; i < lst_non_zeros.size(); i++) {
            nums[i] = lst_non_zeros.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
