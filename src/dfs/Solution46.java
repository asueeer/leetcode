package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lst = new LinkedList<>();
        if(nums.length==0){
            result.add(lst);
            return result;
        }

        int first = nums[0];
        int[] sub_nums = new int[nums.length-1];
        for (int i = 0; i < sub_nums.length; i++) {
            sub_nums[i] = nums[i+1];
        }
        List<List<Integer>> sub_permute = permute(sub_nums);
        System.out.println(sub_permute);

        for (int i = 0; i < sub_permute.size(); i++) {
            int len = sub_permute.get(i).size();
            for (int j = 0; j < len+1; j++) {
                List<Integer> sub_lst = new LinkedList<>(sub_permute.get(i));
                sub_lst.add(j,first);
                result.add((sub_lst));
            }
        }
        return result;
    }
}
