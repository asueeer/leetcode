package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static dfs.Solution46.permute;
import static java.util.Collections.sort;

/**
 * @author wangyisu
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = permute(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            set.add(result.get(i));
        }
        result.clear();
        for (Iterator<List<Integer>> it = set.iterator(); it.hasNext(); ) {
            List<Integer> list = it.next();
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(1);
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(list1);
        set.add(list2);
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
        System.out.println(set);
    }
}
