package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Collections.reverse;

/**
 * @author wangyisu
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        que1.offer(root);
        while (!que1.isEmpty() || !que2.isEmpty()){
            ArrayList<Integer> levelValues = new ArrayList<>();
            while (!que1.isEmpty()){
                TreeNode temp = que1.poll();
                if(temp.left!=null){
                    que2.offer(temp.left);
                }
                if(temp.right!=null){
                    que2.offer(temp.right);
                }
                levelValues.add(temp.val);
            }
            if(levelValues.size()!=0){
                result.add(new ArrayList<>(levelValues));
            }
            levelValues.clear();
            while (!que2.isEmpty()){
                TreeNode temp = que2.poll();
                if(temp.left!=null){
                    que1.offer(temp.left);
                }
                if(temp.right!=null){
                    que1.offer(temp.right);
                }
                levelValues.add(temp.val);
            }
            if(levelValues.size()!=0){
                result.add(new ArrayList<>(levelValues));
            }

            levelValues.clear();
        }

        makeZigZag(result);
        return result;
    }

    private void makeZigZag(List<List<Integer>> result) {

        for (int i = 0; i < result.size(); i++) {
            if(i%2==1){
                reverse(result.get(i));
            }
        }

    }

    public static void main(String[] args) {

//[1,2,3,4,null,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        Solution103 solu = new Solution103();
        System.out.println(solu.zigzagLevelOrder(root));
    }
}
