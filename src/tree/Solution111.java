package tree;

/**
 * @author wangyisu
 */
public class Solution111 {
    int result = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth = 1;
        dfs(root, depth);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if(root.right==null && root.left==null){
            result = Math.min(depth, result);
        }
        if(root.right!=null){
            dfs(root.right, depth + 1);
        }
        if(root.left!=null){
            dfs(root.left, depth + 1);
        }
    }

    public static void main(String[] args) {

    }
}
