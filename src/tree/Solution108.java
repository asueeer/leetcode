package tree;


import java.util.Arrays;

/**
 * @author wangyisu
 */

// 2/2 = 1
// 3/2 = 1
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        // 选出中位数
        int mid_index = nums.length/2;
        if(nums.length%2==1){
            mid_index = nums.length/2;
        }

        TreeNode root = new TreeNode(nums[mid_index]);
        System.out.println(nums[mid_index]);
        int[] nums_left = new int[mid_index]; // 这里应该写一个函数来解决copy问题，或者用现有的函数
        for (int i = 0; i < nums_left.length; i++) {
            nums_left[i] = nums[i];
        }
        int[] nums_right = new int[nums.length - mid_index - 1];
        for (int i = 0; i < nums_right.length; i++) {
            nums_right[i] = nums[i + mid_index + 1];
        }
        System.out.println(Arrays.toString(nums_left));
        System.out.println(Arrays.toString(nums_right));

        root.left = sortedArrayToBST(nums_left);
        root.right = sortedArrayToBST(nums_right);
        return root;
    }

    public static void main(String[] args) {
        Solution108 solu = new Solution108();
        TreeNode root = solu.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(root.val);
    }
}
