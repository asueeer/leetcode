package tree;

/**
 * @author wangyisu
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int max_index = findMax_Index(nums);
        TreeNode root = new TreeNode(nums[max_index]);
        int[] nums_left = new int[max_index];
        int[] nums_right = new int[nums.length - max_index - 1];
        for (int i = 0; i < max_index; i++) {
            nums_left[i] = nums[i];
        }
        for (int i = max_index+1; i < nums.length; i++) {
            nums_right[i-max_index-1] = nums[i];
        }
        root.left = constructMaximumBinaryTree(nums_left);
        root.right = constructMaximumBinaryTree(nums_right);
        return root;
    }

    private int findMax_Index(int[] nums) {
        int max_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>nums[max_index]){
                max_index = i;
            }
        }
        return max_index;
    }


    public static void main(String[] args) {
        int[] nums = new int[0];
        System.out.println(nums);
    }
}
