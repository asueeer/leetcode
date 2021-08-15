package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTravel(root, result);
        return result;
    }

    public void preorderTravel(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        result.add(root.val);
        if(root.left!=null){
            preorderTravel(root.left, result);
        }
        if(root.right!=null){
            preorderTravel(root.right, result);
        }
    }

    public List<TreeNode> preorderTraversalII(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        preorderTravelII(root, result);
        return result;
    }

    public void preorderTravelII(TreeNode root, List<TreeNode> result){
        if(root==null){
            return;
        }
        result.add(root);
        if(root.left!=null){
            preorderTravelII(root, result);
        }
        if(root.right!=null){
            preorderTravelII(root, result);
        }
    }
}
