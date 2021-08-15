package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wangyisu
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> levelOrder = levelOrder(root);
        ArrayList<Integer> levelReverseOrder = levelReverseOrder(root);

        for (int i = 0; i < levelOrder.size(); i++) {
            if(!Objects.equals(levelOrder.get(i), levelReverseOrder.get(i))){
                return false;
            }
        }
        System.out.println(levelOrder);
        System.out.println(levelReverseOrder);
        return true;
    }

    private ArrayList<Integer> levelReverseOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp==null){
                result.add(null);
                continue;
            }
            result.add(temp.val);
            queue.offer(temp.right);
            queue.offer(temp.left);
        }
        return result;
    }

    private ArrayList<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp==null){
                result.add(null);
                continue;
            }
            result.add(temp.val);
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return result;
    }


    public static void main(String[] args) {
//        [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution101 solu = new Solution101();
        System.out.println(solu.isSymmetric(root));
    }

}
