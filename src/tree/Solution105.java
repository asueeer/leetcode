package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static string.reformatString.reformat;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * @author wangyisu
 */

public class Solution105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length==1){
            return root;
        }
        int leftSubTree_length = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]!=root.val){
                leftSubTree_length++;
            }else{
                break;
            }
        }
        System.out.println(leftSubTree_length);
        int[] leftSubTreePreOrder = new int[leftSubTree_length];
        int[] leftSubTreeInOrder = new int[leftSubTree_length];
        int[] rightSubTreePreOrder = new int[inorder.length - 1 - leftSubTree_length];
        int[] rightSubTreeInOrder = new int[inorder.length - 1 - leftSubTree_length];
        for (int i = 0; i < leftSubTree_length; i++) {
            leftSubTreePreOrder[i] = preorder[i+1];
            leftSubTreeInOrder[i] = inorder[i];
        }
        for (int i = 0; i < inorder.length - 1 - leftSubTree_length; i++) {
            rightSubTreePreOrder[i] = preorder[1+leftSubTree_length+i];
            rightSubTreeInOrder[i] = inorder[1+leftSubTree_length+i];
        }
        System.out.println(Arrays.toString(leftSubTreePreOrder));
        System.out.println(Arrays.toString(leftSubTreeInOrder));
        System.out.println(Arrays.toString(rightSubTreePreOrder));
        System.out.println(Arrays.toString(rightSubTreeInOrder));
        root.left = buildTree(leftSubTreePreOrder, leftSubTreeInOrder);
        root.right = buildTree(rightSubTreePreOrder, rightSubTreeInOrder);
        return root;
    }

    public static void main(String[] args) {
//        System.out.println(reformat("[3,9,20,15,7]\n" +
//                "[9,3,15,20,7]"));
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
