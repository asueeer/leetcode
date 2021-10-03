package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution526 {
    int cnt;

    public int countArrangement(int n) {
        cnt = 0;
        dfs(n, new LinkedList<>(), new boolean[n + 1]);
        return cnt;
    }

    private void dfs(int n, List<Integer> lst, boolean[] bitMap) {
        if (lst.size() > 0) {
            if (notBeautiful(lst.size(), lst.get(lst.size() - 1))) {
                return;
            }
        }
        if (lst.size() == n) {
            cnt++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (bitMap[i]) {
                continue;
            }
            lst.add(i);
            bitMap[i] = true;
            dfs(n, lst, bitMap);
            lst.remove(lst.size() - 1); // 移出最后一个元素
            bitMap[i] = false;
        }
    }

    // 漂亮的: 任意一方能被另一方整除
    public boolean notBeautiful(int i, int j) {
        return i % j != 0 && j % i != 0;
    }

    // 优美的序列，定义是序列上的每一位和上面的值都是漂亮的
    public boolean isPerfect(List<Integer> perm) {
        boolean perfect = true;
        for (int i = 0; i < perm.size(); i++) {
            int pos = i + 1;
            if (notBeautiful(pos, perm.get(i))) {
                perfect = false;
                break;
            }
        }
        return perfect;
    }


    public int countArrangement1(int n) {
        List<List<Integer>> perms = getPerms(n);
        int cnt = 0;
        for (List<Integer> perm : perms) {
            if (isPerfect(perm)) {
                cnt++;
            }
        }
        return cnt;
    }

    private List<List<Integer>> getPerms(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n == 0) {
            ret.add(new LinkedList<>());
            return ret;
        }
        List<List<Integer>> perms = getPerms(n - 1);
        for (List<Integer> perm : perms) {
            for (int j = 0; j <= perm.size(); j++) {
                List<Integer> lst = new LinkedList<>(perm);
                lst.add(j, n);
                ret.add(lst);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution526 solu = new Solution526();
//        System.out.println(solu.getPerms(2));
//
//        System.out.println(solu.countArrangement(2));
//        System.out.println(solu.countArrangement(11));
        for (int i = 1; i < 100; i++) {
            System.out.println(i + ": " + solu.countArrangement(i));
        }
    }
}
