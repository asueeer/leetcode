package dfs;

import java.util.*;

import static dfs.Solution78.subsets;
import static java.util.Collections.sort;

/**
 * @author wangyisu
 */
public class Solution90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = subsets(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < subsets.size(); i++) {
            List<Integer> lst = subsets.get(i);
            sort(lst);
        }
        for (int i = 0; i < subsets.size(); i++) {
            set.add(subsets.get(i));
        }
        subsets.clear();
        for (Iterator<List<Integer>> it = set.iterator(); it.hasNext(); ) {
            List<Integer> list = it.next();
            subsets.add(list);
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
