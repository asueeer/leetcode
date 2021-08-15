package tree;

import binary.devide.Solution278;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangyisu
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root){
        int max = 0;
        if(root==null){
            return max;
        }
        Queue<TreeNode> que_1 = new LinkedList<>();
        Queue<TreeNode> que_2 = new LinkedList<>();
        List<Integer> levelList = new ArrayList<>();
        que_1.offer(root);
        root.val = 1;
        int nodes = 0;
        while(!que_1.isEmpty() || !que_2.isEmpty()){
            while(!que_1.isEmpty()){
                TreeNode cur = que_1.poll();
                if(cur.left!=null){
                    cur.left.val = cur.val*2;
                    que_2.offer(cur.left);
                }
                if(cur.right!=null){
                    cur.right.val = cur.val*2 + 1;
                    que_2.offer(cur.right);
                }
                levelList.add(cur.val);
            }
            if(levelList.size()!=0){
                nodes = levelList.get(levelList.size()-1) - levelList.get(0) + 1;
                if(nodes>max){
                    max = nodes;
                }
            }
            levelList.clear();
            while(!que_2.isEmpty()){
                TreeNode cur = que_2.poll();
                if(cur.left!=null){
                    cur.left.val = cur.val*2;
                    que_1.offer(cur.left);
                }
                if(cur.right!=null){
                    cur.right.val = cur.val*2 + 1;
                    que_1.offer(cur.right);
                }
                levelList.add(cur.val);
            }
            if(levelList.size()!=0){
                nodes = levelList.get(levelList.size()-1) - levelList.get(0) + 1;
                if(nodes>max){
                    max = nodes;
                }
            }
            levelList.clear();
        }
        return max;
    }

    public int widthOfBinaryTree_1(TreeNode root) {
        int max = 0;
        if(root==null){
            return max;
        }
        Queue<TreeNode> que_1 = new LinkedList<>();
        Queue<TreeNode> que_2 = new LinkedList<>();
        que_1.offer(root);
        while(!que_1.isEmpty() || !que_2.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            Boolean haveValidNode = false;
            while(!que_1.isEmpty()){
                TreeNode cur = que_1.poll();
                if(cur==null){
                    que_2.offer(null);
                    que_2.offer(null);
                    levelList.add(0);
                    continue;
                }
                if(cur.left!=null){
                    que_2.offer(cur.left);
                }else{
                    que_2.offer(null);
                }
                if(cur.right!=null){
                    que_2.offer(cur.right);
                }else{
                    que_2.offer(null);
                }
                levelList.add(1);
                haveValidNode = true;
            }
            if(haveValidNode!=true){
                break;
            }
            int nodes = nodesNumber(levelList);
            if(max<nodes){
                max = nodes;
            }
            levelList.clear();
            haveValidNode = false;
            while(que_2.size()!=0){
                TreeNode cur = que_2.poll();
                if(cur==null){
                    que_1.offer(null);
                    que_1.offer(null);
                    levelList.add(0);
                    continue;
                }
                if(cur.left!=null){
                    que_1.offer(cur.left);
                }else{
                    que_1.offer(null);
                }
                if(cur.right!=null){
                    que_1.offer(cur.right);
                }else{
                    que_1.offer(null);
                }
                levelList.add(1);
                haveValidNode = true;
            }
            if(haveValidNode!=true){
                break;
            }
            nodes = nodesNumber(levelList);
            if(max<nodes){
                max = nodes;
            }
        }
        return max;
    }

    private int nodesNumber(List<Integer> list) {
        int start = 0;
        int end = list.size()-1;
        while(list.get(start)==0){
            start++;
        }
        while(list.get(end)==0){
            end--;
        }
        int width = end - start + 1;
        return width;
    }

    public List<List<TreeNode>> levelTrans(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que_1 = new LinkedList<>();
        Queue<TreeNode> que_2 = new LinkedList<>();
        que_1.offer(root);
        while(!que_1.isEmpty() || !que_2.isEmpty()){
            List<TreeNode> levelList = new ArrayList<>();
            Boolean haveValidNode = false;
            while(!que_1.isEmpty()){
                TreeNode cur = que_1.poll();
                levelList.add(cur);
                if(cur==null){
                    que_2.offer(null);
                    que_2.offer(null);
                    continue;
                }
                if(cur.left!=null){
                    que_2.offer(cur.left);
                }else{
                    que_2.offer(null);
                }
                if(cur.right!=null){
                    que_2.offer(cur.right);
                }else{
                    que_2.offer(null);
                }
                haveValidNode = true;
            }
            if(haveValidNode!=true){
                break;
            }
            result.add(new ArrayList<>(levelList));
            levelList.clear();
            haveValidNode = false;
            while(que_2.size()!=0){
                TreeNode cur = que_2.poll();
                levelList.add(cur);
                if(cur==null){
                    que_1.offer(null);
                    que_1.offer(null);
                    continue;
                }
                if(cur.left!=null){
                    que_1.offer(cur.left);
                }else{
                    que_1.offer(null);
                }
                if(cur.right!=null){
                    que_1.offer(cur.right);
                }else{
                    que_1.offer(null);
                }
                haveValidNode = true;
            }
            if(haveValidNode!=true){
                break;
            }
            result.add(new ArrayList<>(levelList));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("测试用例1");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        Solution662 solution662 = new Solution662();
        List<List<TreeNode>> result = solution662.levelTrans(root);
        for(List<TreeNode> line:result){
            System.out.println(line);
        }
        System.out.println(solution662.maxWidth(result));
        System.out.println(solution662.widthOfBinaryTree(root));
        System.out.println("--------");
        System.out.println("测试用例2");
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        result = solution662.levelTrans(root);
        for(List<TreeNode> line:result){
            System.out.println(line);
        }
        System.out.println(solution662.maxWidth(result));
        System.out.println("--------");
        System.out.println("测试用例3");
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        result = solution662.levelTrans(root);
        for(List<TreeNode> line:result){
            System.out.println(line);
        }
        System.out.println(solution662.maxWidth(result));
        System.out.println("--------");
        System.out.println("测试用例4");
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        result = solution662.levelTrans(root);
        for(List<TreeNode> line:result){
            System.out.println(line);
        }
        System.out.println(solution662.maxWidth(result));
        System.out.println("----widthOfBinaryTree_1----");
        System.out.println(solution662.widthOfBinaryTree_1(root));
        System.out.println("----widthOfBinaryTree----");
        System.out.println(solution662.widthOfBinaryTree(root));
    }

    private int maxWidth(List<List<TreeNode>> lists) {
        int max = 0;
        if(lists==null){
            return max;
        }
        for(List<TreeNode> list:lists){
            int start = 0;
            int end = list.size()-1;
            while(list.get(start)==null){
                start++;
            }
            while(list.get(end)==null){
                end--;
            }
            int width = end - start + 1;
            if(width>max){
                max = width;
            }
        }
        return max;
    }
}
