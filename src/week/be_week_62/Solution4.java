package week.be_week_62;

import java.util.Arrays;

public class Solution4 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int L = original.length;

        int[][] ret = new int[][]{};

        boolean flag = L == (m * n);
        if (!flag) {
            return ret;
        }

        ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = original[i * n + j];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(Arrays.deepToString(solu.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
        System.out.println(Arrays.deepToString(solu.construct2DArray(new int[]{1, 2, 3}, 1, 3)));
    }
}
