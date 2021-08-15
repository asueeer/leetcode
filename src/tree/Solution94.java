package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTravel(root, result);
        return result;
    }

    public static void inorderTravel(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inorderTravel(root.left, result);
        }
        result.add(root.val);
        if(root.right!=null){
            inorderTravel(root.right, result);
        }
    }

    public static List<TreeNode> inorderTraversalII(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        inorderTravelII(root, result);
        return result;
    }

    public static void inorderTravelII(TreeNode root, List<TreeNode> result){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inorderTravelII(root, result);
        }
        result.add(root);
        if(root.right!=null){
            inorderTravelII(root, result);
        }
    }
}
