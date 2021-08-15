package tree;

import java.util.ArrayList;

import static java.util.Collections.max;

/**
 * @author wangyisu
 */
public class Solution124_recursion {
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        ArrayList<Integer> possibleResults = new ArrayList<>();
        if(root.left!=null){
            possibleResults.add(root.val);
            possibleResults.add(maxPathSum(root.left) + root.val);
            possibleResults.add(maxPathSum(root.left));
        }
        if(root.right!=null){
            possibleResults.add(root.val + maxPathSum(root.right));
            if(root.left!=null){
                possibleResults.add(maxPathSum(root.left) + root.val + maxPathSum(root.right));
            }
            possibleResults.add(maxPathSum(root.right));
        }
        return max(possibleResults);
    }
}
