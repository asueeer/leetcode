package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static tree.Solution94.inorderTraversalII;

/**
 * @author wangyisu
 */
public class Solution124 {
    public class Node{
        int val;
        Node left;
        Node right;
        Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public int maxPathSum(TreeNode root) {
        Node rootNode = buildNodeTree(root, null);
        ArrayList<Node> nodes = new ArrayList<>();
        preOrderTravel(rootNode, nodes);
        int result = Integer.MIN_VALUE;
        HashSet<Node> visited = new HashSet<>();
        for (int i = 0; i < nodes.size(); i++) {
            visited.clear();
            ArrayList<Integer> pathSumSets = new ArrayList<>();
            visited.add(nodes.get(i));
            roam(nodes.get(i),visited, pathSumSets, 0);
//            if(pathSumSets.size()!=0 && result<pathSumSets.get(0)){
//                result = pathSumSets.get(0);
//            }
            result = Math.max(result, pathSumSets.get(0));
        }
        return result;
    }

    private void roam(Node cur, HashSet<Node> visited, ArrayList<Integer> pathSumSets, int pathSum) {
        pathSum+=cur.val; // pathSum每加一次，就判断一次
        if(pathSumSets.size()==0){ //set中只保存一个最大的值
            pathSumSets.add(pathSum);
        }else{
            pathSumSets.set(0,Math.max(pathSum, pathSumSets.get(0)));
        }
        if(!visited.contains(cur.parent) && cur.parent!=null){
            visited.add(cur.parent);
            roam(cur.parent, visited, pathSumSets, pathSum);
        }
        if(!visited.contains(cur.left) && cur.left!=null){
            visited.add(cur.left);
            roam(cur.left, visited, pathSumSets, pathSum);
        }
        if(!visited.contains(cur.right) && cur.right!=null){
            visited.add(cur.right);
            roam(cur.right, visited, pathSumSets, pathSum);
        }
    }

    private void preOrderTravel(Node root_node, ArrayList<Node> nodes) {
        if(root_node!=null){
            nodes.add(root_node);
        }
        if(root_node.left!=null){
            preOrderTravel(root_node.left, nodes);
        }
        if(root_node.right!=null){
            preOrderTravel(root_node.right, nodes);
        }
    }

    private Node buildNodeTree(TreeNode treeNode, Node parent) {
        Node node = new Node(treeNode.val);
        node.parent = parent;
        if(treeNode.left!=null){
            node.left = buildNodeTree(treeNode.left, node);
        }else{
            node.left = null;
        }
        if(treeNode.right!=null){
            node.right = buildNodeTree(treeNode.right, node);
        }else{
            node.right = null;
        }
        return node;
    }

    public static void main(String[] args) {
        Solution124 solu = new Solution124();
        System.out.println("测试用例1");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Node root_node = solu.buildNodeTree(root, null);
//        System.out.println(root_node.val);
//        System.out.println(root_node.left.left.val);
        System.out.println(solu.maxPathSum(root));
    }


    // 写完之后发现题意理解错了
    public int rootMaxPathSum(TreeNode root) {
        int sum_ = 0;
        ArrayList<Integer> result = new ArrayList<>();
        roam_(root, sum_, result);
        int max_ = Integer.MIN_VALUE;
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i)>max_){
                max_ = result.get(i);
            }
        }
        return max_;
    }

    private static void roam_(TreeNode root, int sum_, ArrayList<Integer> result) {
        if(root==null){
            result.add(sum_);
            return;
        }
        sum_+=root.val;
        roam_(root.left, sum_, result);
        roam_(root.right, sum_, result);
    }
}
