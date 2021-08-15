package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution300 {
    private static HashMap<String, List<Integer>> record = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        record.clear();
        List<Integer> list = listOfLIS(nums, 0, nums.length);

        return list.size();
    }

    private List<Integer> listOfLIS(int[] nums, int lo, int hi) {
        String key = lo + " " + hi;
//        System.out.println(key);
//        System.out.println();
        if (record.containsKey(key)) {
            return record.get(key);
        }
        if (lo >= hi - 1) {
            List<Integer> result = new ArrayList<>();
            result.add(nums[lo]);
            record.put(key, result);
            return result;
        }
        int mi = (lo + hi) / 2;
        List<Integer> listLeft = listOfLIS(nums, lo, mi);
        List<Integer> listRight = listOfLIS(nums, mi, hi);
        ArrayList<Integer> listLeftModified = new ArrayList<>(listLeft);
        ArrayList<Integer> listRightModified = new ArrayList<>(listRight);

        int leftmost = listLeft.get(listLeft.size() - 1);
        for (Integer element : listRight) {
            if (element > leftmost) {
                listLeftModified.add(element);
            }
        }

        int rightmost = listRight.get(0);
        for (Integer element : listLeft) {
            if (element < rightmost) {
                listRightModified.add(0, element);
            }
        }
        if (compare(listLeftModified, listRightModified) == 0) {
            record.put(key, listLeftModified);
            return listLeftModified;
        } else {
            record.put(key, listRightModified);
            return listRightModified;
        }
    }

    private int compare(List<Integer> l1, List<Integer> l2) {
        // 0 表示l1更合适, 1 表示l2更合适
        if (l1.size() > l2.size()) {
            return 0;
        } else if (l1.size() < l2.size()) {
            return 1;
        }
        if (l1.get(l1.size() - 1) < l2.get(l2.size() - 1)) {
            return 0;
        } else if (l1.get(l1.size() - 1).equals(l2.get(l2.size() - 1))) {
            if (l1.get(0) < l2.get(0)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution300 solu = new Solution300();
        System.out.println(solu.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solu.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solu.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(solu.lengthOfLIS(new int[]{10,9,2,5,3,4}));
        System.out.println(solu.lengthOfLIS(new int[]{0, 1, 0}));
    }
}
