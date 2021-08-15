package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTravel(root, result);
        return result;
    }

    public static void postorderTravel(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        if(root.left!=null){
            postorderTravel(root.left, result);
        }
        if(root.right!=null){
            postorderTravel(root.right, result);
        }
        result.add(root.val);
    }
}
