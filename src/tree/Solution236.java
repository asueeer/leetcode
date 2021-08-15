package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static tree.Solution102.levelOrderII;
import static tree.Solution104.maxDepth;

/**
 * @author wangyisu
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> levelOrderII = levelOrderII(root);
        int depth_min = Integer.MAX_VALUE;
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        // 一开始从上往下，leetcode时间复杂度超了，后来改成了由下往上，遇到的第一个就直接返回
        for (int i = levelOrderII.size()-1; i > -1; i--) {
            for (int j = 0; j < levelOrderII.get(i).size(); j++) {
                TreeNode cur = levelOrderII.get(i).get(j);
                if(hasChilds(cur,p,q)){
                    return cur;
                }
            }
        }
        return hashMap.get(depth_min);
    }

    public boolean hasChilds(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> levelOrderII = levelOrderII(root);
        boolean hasChildP = false;
        boolean hasChildQ = false;
        for (int i = 0; i < levelOrderII.size(); i++) {
            for (int j = 0; j < levelOrderII.get(i).size(); j++) {
                if(p == levelOrderII.get(i).get(j)){
                    hasChildP = true;
                }
                if(q == levelOrderII.get(i).get(j)){
                    hasChildQ = true;
                }
            }
        }
        if(hasChildP==true && hasChildQ==true){
            return true;
        }else{
            return false;
        }
    }
}
