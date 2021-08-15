package tree;

import hashmap.Solution1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangyisu
 */
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return t == null;
        }
        if(s.val==t.val && judge(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right, t);
    }

    private boolean judge(TreeNode s, TreeNode t) {
        List<Integer> s_preorderTraversal = preorderTraversal(s);
        List<Integer> t_preorderTraversal = preorderTraversal(t);
        List<Integer> s_inorderTraversal = inorderTraversal(s);
        List<Integer> t_inorderTraversal = inorderTraversal(t);
        System.out.println(s_preorderTraversal);
        System.out.println(t_preorderTraversal);
        return s_preorderTraversal.toString().equals(t_preorderTraversal.toString()) && s_inorderTraversal.toString().equals(t_inorderTraversal.toString());
    }

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTravel(root, result);
        return result;
    }

    public void inorderTravel(TreeNode root, List<Integer> result){
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
}
