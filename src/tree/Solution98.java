package tree;

import java.util.List;

import static tree.Solution94.inorderTraversal;
import static tree.Solution94.inorderTraversalII;

/**
 * @author wangyisu
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderValues = inorderTraversal(root);
        // root是二叉搜索树的条件是：它的中序遍历序列是单调递增的
        for (int i = 1; i < inorderValues.size(); i++) {
            if(inorderValues.get(i)<inorderValues.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
