package tree;

/**
 * @author wangyisu
 */
public class Solution104 {
    // 二叉树的最大深度
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
