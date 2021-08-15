package tree;

import static tree.Solution104.maxDepth;

/**
 * @author wangyisu
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        // 遍历左子树
        if(!isBalanced(root.left)){
            return false;
        }
        // 检查root节点
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }
        // 遍历右子树
        if(!isBalanced(root.right)){
            return false;
        }
        return true;
    }
}
