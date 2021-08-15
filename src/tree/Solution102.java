package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangyisu
 */
public class Solution102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que_1 = new LinkedList<>();
        Queue<TreeNode> que_2 = new LinkedList<>();
        que_1.offer(root);
        while(!que_1.isEmpty() || !que_2.isEmpty()){
            List<Integer> lineValues = new ArrayList<>();
            while(!que_1.isEmpty()){
                TreeNode cur = que_1.poll();
                if(cur.left!=null){
                    que_2.offer(cur.left);
                }
                if(cur.right!=null){
                    que_2.offer(cur.right);
                }
                lineValues.add(cur.val);
            }
            result.add(new ArrayList<>(lineValues));
            lineValues.clear();
            while(que_2.size()!=0){
                TreeNode cur = que_2.poll();
                lineValues.add(cur.val);
                if(cur.left!=null){
                    que_1.offer(cur.left);
                }
                if(cur.right!=null){
                    que_1.offer(cur.right);
                }
            }
            if(!lineValues.isEmpty()){
                result.add(new ArrayList<>(lineValues));
            }
        }
        return result;
    }

    // 存放层次遍历的节点
    public static List<List<TreeNode>> levelOrderII(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que_1 = new LinkedList<>();
        Queue<TreeNode> que_2 = new LinkedList<>();
        que_1.offer(root);
        while(!que_1.isEmpty() || !que_2.isEmpty()){
            List<TreeNode> lineNodes = new ArrayList<>();
            while(!que_1.isEmpty()){
                TreeNode cur = que_1.poll();
                if(cur.left!=null){
                    que_2.offer(cur.left);
                }
                if(cur.right!=null){
                    que_2.offer(cur.right);
                }
                lineNodes.add(cur);
            }
            result.add(new ArrayList<>(lineNodes));
            lineNodes.clear();
            while(que_2.size()!=0){
                TreeNode cur = que_2.poll();
                lineNodes.add(cur);
                if(cur.left!=null){
                    que_1.offer(cur.left);
                }
                if(cur.right!=null){
                    que_1.offer(cur.right);
                }
            }
            if(!lineNodes.isEmpty()){
                result.add(new ArrayList<>(lineNodes));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = levelOrder(root);
        for(List<Integer> lineValues: result){
            System.out.println(lineValues);
        }
    }
}
